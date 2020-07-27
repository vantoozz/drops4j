package com.github.vantoozz.drops4j.client;

import com.github.vantoozz.drops4j.Drop;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

final public class UdpDropsClient implements DropsClient {

    private final InetAddress address;
    private final int port;
    private final DatagramSocket datagramSocket = new DatagramSocket();

    public UdpDropsClient(final InetAddress address, final int port) throws SocketException {
        this.address = address;
        this.port = port;
    }

    @Override
    public void drop(final Drop drop) throws DropsClientException {
        byte[] buffer = drop.json().toString().getBytes();
        try {
            datagramSocket.send(new DatagramPacket(buffer, buffer.length, address, port));
        } catch (IOException e) {
            throw new DropsClientException(e);
        }
    }
}
