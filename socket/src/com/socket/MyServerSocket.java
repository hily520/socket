package com.socket;

public class MyServerSocket {
    public static void main(String[] args) {
        //启动监听线程
        new ServerListening().start();
    }
}
