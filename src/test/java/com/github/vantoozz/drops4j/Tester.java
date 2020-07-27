package com.github.vantoozz.drops4j;

import com.github.vantoozz.drops4j.client.UdpDropsClient;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Tester {

    public static void main(String[] args) throws UnknownHostException, SocketException {

        setup();

        for (int i = 0; i < 5; i++) {
            Drops.drop("aaa", Context.with("i", i).and("tens", (i % 10 == 0)));
        }
    }

    private static void setup() throws SocketException, UnknownHostException {
        Drops.setClient(new UdpDropsClient(InetAddress.getByName("localhost"), 41234));
        Drops.setDefaultContext(Context.with("hostname", "BBB").and("i", "ddd"));
    }
}
