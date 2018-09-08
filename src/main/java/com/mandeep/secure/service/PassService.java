package com.mandeep.secure.service;

public interface PassService {

    void generateAndSave(String siteName,String userName);

    String fetch(String siteName, String userName);
}
