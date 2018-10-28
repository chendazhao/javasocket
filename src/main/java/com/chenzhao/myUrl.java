package com.chenzhao;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName myUrl
 * @Description TODO
 * @Author chenzhao
 * @Date 2018/10/28 14:47
 * @Version 1.0
 **/
public class myUrl {
    public static void main(String[] args) {
        try {
            //创建一个URL的实例
            URL chenzhao=new URL("http://www.chenzhao.art");
            //?后面表示的是参数,#后面表示的是锚点
            URL url=new URL(chenzhao,"/index.html?username=chenzhao#test");
            System.out.println("协议："+url.getProtocol());
            System.out.println("主机："+url.getHost());
            //如果未指定端口号,则使用默认端口号，此时getPort（）方法返回值为-1
            System.out.println("端口："+url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件的名称："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("查询字符串："+ url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
