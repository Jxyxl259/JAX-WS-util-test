package com.springcxf.api.client;

import com.springcxf.api.UserService;
import com.springcxf.api.impl.UserServiceImplService;

/**
 * 测试spring整合CXF工程,测试服务接口为 UserService
 * 服务端的服务接口和实现类包路径不相同
 * wsdl在线描述文档分为两部分显示
 *
 * com.springcxf.api包下除了client包是后来创建的
 * 其余为wsdl2java生成的  辅助客户端调用服务的类
 *
 * 这是用来测试spring整合CXF工程下的SOAP风格的WebService创建的客户端
 */
public class MyClient {

    public static void main(String[] args) {

        UserServiceImplService userServiceImplService  = new UserServiceImplService ();
        UserService userServiceImplPort = userServiceImplService.getUserServiceImplPort();
        System.out.println(userServiceImplPort.getUserInfo("370983").getRegisterDate());
    }

}
