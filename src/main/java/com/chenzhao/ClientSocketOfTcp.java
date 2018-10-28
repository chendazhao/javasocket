package com.chenzhao;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName ClientSocketOfTcp
 * @Description TODO
 * @Author chenzhao
 * @Date 2018/10/28 15:59
 * @Version 1.0
 **/
public class ClientSocketOfTcp {
    public static void main(String[] args) {

        try {
            //1、创建客户端Socket,指定服务器地址和端口
            Socket socket=new Socket("localhost",8888);
            //2、获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            PrintWriter pw=new PrintWriter(os);//将输出流转换/包装为打印流
            pw.write("用户名：chenzhao;密码：123456");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3、获取输入流，用来读取服务端的响应信息
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=null;
            while ((info=br.readLine())!=null){
                System.out.println("我客户端，服务器说："+info);
            }

            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
