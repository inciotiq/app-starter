package com.iotiq.appstarter.user.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Credentials implements Serializable {
    String password;
    boolean credentialsNonExpired;
}
