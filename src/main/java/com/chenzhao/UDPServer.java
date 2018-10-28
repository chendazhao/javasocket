package com.chenzhao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @ClassName UDPServer
 * @Description 服务器端,实现基于UDP的用户登录
 * @Author chenzhao
 * @Date 2018/10/28 17:06
 * @Version 1.0
 **/
public class UDPServer {
    public static void main(String[] args) throws IOException {
        /**
           接受客户端发送的数据
         */
        //1、创建服务器端DatagramSocket，指定端口号
        DatagramSocket socket=new DatagramSocket(8800);
        //2、创建数据报,用于接受客户端发送的数据
        byte[] data=new byte[1024];//创建字节数组，指定接受的数据包的大小'
        System.out.println("********我是服务端，正在等待客户端连接*********");
        DatagramPacket packet=new DatagramPacket(data,data.length);
        //3、接受客户端发送的数据
        socket.receive(packet);//此方法在接受到数据报之前会一直阻塞
        //4、读取数据
        String info=new String(data,0,packet.getLength());
        System.out.println("我是服务器，客户端说："+info);

        /**
            向客户端响应数据
         */

        //1、定义客户端的地址、端口号、数据
        InetAddress address=packet.getAddress();
        int port=packet.getPort();
        byte[] data1="欢迎您！".getBytes();
        //2、创建数据报，包含响应的信息
        DatagramPacket packet1=new DatagramPacket(data1,data1.length,address,port);
        //3、响应客户端
        socket.send(packet1);
        //4、关闭资源
        socket.close();
    }
}
















