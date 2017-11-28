package com.demo.soap.webservice.client;

import com.demo.soap.webservice.server_01.DemoFunctionInterface;
import com.demo.soap.webservice.server_01.DemoFunctionInterfaceImplService;

/**
 * 使用wsdl2java工具类将服务端发布出来的服务的WSDL描述文档  自动生成供客户端调用的类
 * 调用的是soap_style_webservice那个工程中
 * DemoFunctionInterface服务接口
 *
 * server为wsdl2java生成的  辅助客户端调用服务的类
 * 后来我又将包名改为server_01
 *
 * 注意,一般情况下,server包下的内容是被打成jar包添加进本项目中的,
 * 但是毕竟WSDL2JAVA生成的.java文件是要先拷进项目中的,
 * 如果我们想更改包的路径,那么仅更改包的路径
 * 在IDEA修改包名的对话框中不要勾选Search in comments and settings和 Search for text occurrences
 * 两个选项,不然WSDL2JAVA生成的.java文件中的一些涉及包名路径反写的URL就会收到影响,
 * 导致调用服务的时候报错,找不到服务.
 */
public class MyClient {

    public static void main(String[] args) {

        DemoFunctionInterfaceImplService demoFunctionInterfaceImplService = new DemoFunctionInterfaceImplService();
        DemoFunctionInterface demoFunctionInterfaceImpl = demoFunctionInterfaceImplService.getDemoFunctionInterfaceImplPort();
        System.out.println(demoFunctionInterfaceImpl.sayHello("jxy"));
    }

}
