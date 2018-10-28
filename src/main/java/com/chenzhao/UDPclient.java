package com.chenzhao;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName UDPclient
 * @Description 客户端的实现
 * @Author chenzhao
 * @Date 2018/10/28 17:06
 * @Version 1.0
 **/
public class UDPclient {
    public static void main(String[] args) throws IOException {
        /**
                向服务器端发送数据
         */
        //1、定义服务器的地址、端口号、数据
        InetAddress address=InetAddress.getByName("localhost");
        int port=8800;
        byte[] data="用户名：chenzhao;密码：123456".getBytes();
        //2、创建数据报，包含发送的信息
        DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
        //3、创建DatagramSocket对象
        DatagramSocket socket=new DatagramSocket();
        //4、向服务器端发送数据报
        socket.send(packet);

        /**
            接受服务端响应的数据
         */
        //1、创建数据报，用于接受服务端响应数据
        byte[] data1=new byte[1024];
        DatagramPacket packet1=new DatagramPacket(data1,data1.length);
        //2、接受服务器响应的数据
        socket.receive(packet1);
        //3、读取数据
        String reply=new String(data1,0,packet1.getLength());
        System.out.println("我是客户端，服务器说："+reply);
        //4、关闭资源
        socket.close();
    }
}

















