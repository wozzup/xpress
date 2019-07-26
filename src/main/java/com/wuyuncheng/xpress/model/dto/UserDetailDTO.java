package com.wuyuncheng.xpress.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@JsonPropertyOrder({"id"})
@Data
public class UserDetailDTO implements Serializable {

    @JsonProperty("id")
    private Integer userId;
    private String username;
    private String nickname;
    private long postCount;
    private long pageCount;

}
