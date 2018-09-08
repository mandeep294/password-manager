package com.mandeep.secure.repository;

import com.mandeep.secure.model.PsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface PsMasterRepository extends JpaRepository<PsMaster,Long>{

    Optional<PsMaster> findBySiteNameAndUserName(String siteName, String userName);
}
