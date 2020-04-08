package com.socket;


import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//服务器监听代码：
public class ServerListening extends Thread {
    @Override
    public void run() {
        try {
            @SuppressWarnings("resource")
            //创建一个socket监听端口12345，端口取值范围1-65535
                    /*InetAddress bindip = InetAddress.getByName("172.17.16.8");
                    ServerSocket serverSocket = new ServerSocket(12345);
*/
                    ServerSocket serverSocket = new ServerSocket(12345, 0, InetAddress.getByName("172.17.16.8"));

            //通过循环实现一直监听12345端口
            while (true) {
                Socket socket = serverSocket.accept();
                //当有客户端连接到端口是，弹出消息提示框提示
                // JOptionPane.showMessageDialog(null, "有客户端连接到本机12345端口");
                System.out.println("有客户端连接到本机12345端口");
                //把连接的客户端传到新的线程
                ChatSocket csChatSocket = new ChatSocket(socket);
                csChatSocket.start();
                //将连接的通信添加到服务器管理集合
                ServerManager.getServetManager().add(csChatSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}