package com.mandeep.secure.service;

import com.mandeep.secure.util.AppConstants;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.UUID;

@Service
public class GeneratorServiceImpl implements GeneratorService, AppConstants {
    @Value("${encryptKey}")
    String encryptKey;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public char[] generatePassword(String siteName, String userName) {

        String rand = UUID.randomUUID().toString() + siteName + "@" + userName;
        return bCryptPasswordEncoder.encode(rand).toCharArray();
    }

    /*public static String calculateHmac(String key, String data) {

        String signature = "";
        try {
            // byte[] decodedKey = Hex.decodeHex(key.toCharArray());
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(keySpec);
            byte[] dataBytes = data.getBytes("UTF-8");
            byte[] signatureBytes = mac.doFinal(dataBytes);
            signature = new String(Base64.encodeBase64(signatureBytes), "UTF-8");
            System.out.println(signatureBytes.toString());
        } catch (Exception e) {
        }
        return signature;
    }*/
}
