package com.mandeep.secure.model;

import com.mandeep.secure.service.GeneratorService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ps_master")
public class PsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String siteName;

    private String userName;

    private String pwd;

    private String lastPwd;

    private Date created;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getSiteName() {

        return siteName;
    }

    public void setSiteName(String siteName) {

        this.siteName = siteName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPwd() {

        return pwd;
    }

    public void setPwd(String pwd) {

        this.pwd = pwd;
    }

    public String getLastPwd() {

        return lastPwd;
    }

    public void setLastPwd(String lastPwd) {

        this.lastPwd = lastPwd;
    }

    public Date getCreated() {

        return created;
    }

    public void setCreated(Date created) {

        this.created = created;
    }

    public Date getUpdated() {

        return updated;
    }

    public void setUpdated(Date updated) {

        this.updated = updated;
    }

    private Date updated;

}
