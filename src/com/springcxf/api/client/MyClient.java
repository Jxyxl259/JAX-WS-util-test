package com.springcxf.api.client;

import com.springcxf.api.UserService;
import com.springcxf.api.impl.UserServiceImplService;

public class MyClient {

    public static void main(String[] args) {

        UserServiceImplService userServiceImplService  = new UserServiceImplService ();
        UserService userServiceImplPort = userServiceImplService.getUserServiceImplPort();
        System.out.println(userServiceImplPort.getUserInfo("370983").getRegisterDate());
    }

}
