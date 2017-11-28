package com.demo.soap.webservice.client;

import com.demo.soap.webservice.server_01.DemoFunctionInterface;
import com.demo.soap.webservice.server_01.DemoFunctionInterfaceImplService;

/**
 * 使用wsdl2java工具类将服务端发布出来的服务的WSDL描述文档  自动生成供客户端调用的类
 * 调用的是soap_style_webservice那个工程中
 * DemoFunctionInterface服务接口
 */
public class MyClient {

    public static void main(String[] args) {

        DemoFunctionInterfaceImplService demoFunctionInterfaceImplService = new DemoFunctionInterfaceImplService();
        DemoFunctionInterface demoFunctionInterfaceImpl = demoFunctionInterfaceImplService.getDemoFunctionInterfaceImplPort();
        System.out.println(demoFunctionInterfaceImpl.sayHello("jxy"));
    }

}
