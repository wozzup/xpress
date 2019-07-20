package com.wuyuncheng.xpress.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String username;
    private String mail;
    private String url;
    private String nickname;
    private Integer created;

}
