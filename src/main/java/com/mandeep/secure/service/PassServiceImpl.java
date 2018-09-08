package com.mandeep.secure.service;

import com.mandeep.secure.model.PsMaster;
import com.mandeep.secure.repository.PsMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PassServiceImpl implements PassService {
    @Autowired
    GeneratorService generatorService;
    @Autowired
    PsMasterRepository psMasterRepository;

    @Override
    @CacheEvict("sites")
    @CachePut("sites")
    public void generateAndSave(String siteName, String userName) {

        char[] encodedPassword = generatorService.generatePassword(siteName, userName);
        saveOrUpdate(siteName, userName, encodedPassword);
    }

    @Override
    @Cacheable("sites")
    public String fetch(String siteName, String userName) {

        Optional<PsMaster> masterOptional = psMasterRepository.findBySiteNameAndUserName(siteName,
                userName);

        if(masterOptional.isPresent()){
            PsMaster master = masterOptional.get();
            return master.getPwd();
        }
        return "Not Present. Generate First";
    }
    private void saveOrUpdate(String siteName, String userName, char[] encodedPassword) {

        Optional<PsMaster> masterOptional = psMasterRepository.findBySiteNameAndUserName(siteName, userName);
        if (masterOptional.isPresent()) {
            masterOptional.ifPresent(psMaster -> {
                psMaster.setLastPwd(psMaster.getPwd());
                psMaster.setPwd(encodedPassword.toString());
                psMasterRepository.save(psMaster);
            });
        } else {
            PsMaster master = new PsMaster();
            master.setPwd(encodedPassword.toString());
            master.setSiteName(siteName);
            master.setUserName(userName);
            master.setCreated(new Date());
            master.setLastPwd(null);
            psMasterRepository.save(master);
        }
    }
}
