package com.example.webpagesocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class GetWebPageUsingSockets {

    public static void main(String[] args) {
        String urlString;

        urlString = "www.google.com";

        accessWeb(urlString);
    }

    private static void accessWeb(String urlString) {
        String host;
        String page;
        int slashLoc;

        // Set up encoding and decoding
        Charset charset = Charset.forName("ISO-8859-1");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        if ((slashLoc = urlString.indexOf('/')) < 0) {
            host = urlString;
            page = "";
        } else {
            host = urlString.substring(0, slashLoc);
            page = urlString.substring(slashLoc);
        }

        System.out.println("Accessing web page demonstration");
        System.out.println("Host: '" + host + "' Page: '" + page + "'");

        SocketChannel channel = null;

        try {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);

            InetSocketAddress socketAddress = new InetSocketAddress(host, 80);
            channel = SocketChannel.open();
            channel.connect(socketAddress);

            String request = "GET " + page + " \r\n\r\n";
            channel.write(encoder.encode(CharBuffer.wrap(request)));

            while ((channel.read(buffer)) != -1) {
                buffer.flip();
                decoder.decode(buffer, charBuffer, false);
                charBuffer.flip();
                System.out.println(charBuffer);
                buffer.clear();
                charBuffer.clear();
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException ignored) {
                }
            }
        }

        System.out.println("\nDone.");
    }
}