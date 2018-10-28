package com.chenzhao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @ClassName Test01
 * @Description InetAddress类
 * @Author chenzhao
 * @Date 2018/10/28 14:26
 * @Version 1.0
 **/
public class Test01 {

    public static void main(String[] args) throws UnknownHostException {
            //获取本机的InetAddress实例
            //由于InetAddress没有提供构造方法，所以不能直接new一个实例，但是却提供了很多静态方法，可以直接调用
        InetAddress address=InetAddress.getLocalHost();
        System.out.println("计算机名:"+address.getHostName());
        System.out.println("IP地址："+address.getHostAddress());
        byte[] bytes=address.getAddress();//获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP地址:"+ Arrays.toString(bytes));
        System.out.println( address);//直接输出InetAddress对象

        //根据机器名获取InetAddress实例
        //InetAddress address1=InetAddress.getByName("LAPTOP-HD9O23FF");
        InetAddress address1=InetAddress.getByName("www.chenzhao.art");
        System.out.println("计算机名:"+address1.getHostName());
        System.out.println("IP地址："+address1.getHostAddress());
    }
}
