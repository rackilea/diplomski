package com.example

import java.io.InputStream
import java.net.ServerSocket
import java.net.Socket

object CLIThread extends Thread(CLIRunner) {
    def pool: String = CLIRunner.pool
    def shutdown() = CLIRunner.shutdown()
}

protected final object CLIRunner extends Runnable {
    var listener: ServerSocket = null
    var socket: Socket = null
    var in: InputStream = null
    private var keepAlive = true

    private var _pool = ""

    def run: Unit = {
        var ok = false
        while (!ok) {
            try {
                listener = new ServerSocket((math.random * 10000).toInt)
                ok = true;
            }
            catch {
                case _ => {}
            }
        }
        socket = listener.accept()
        in = socket.getInputStream
        while (keepAlive) {
            while (in.available() > 0) _pool += in.read().toChar
        }

    }
    def pool: String = if (in != null) {
        val temp = _pool
        _pool = ""
        return temp
    }
    else if (listener != null) (listener.getInetAddress, listener.getLocalPort).toString
    else "listener == null..."

    def shutdown() {
        keepAlive = false
        if (listener != null) {
            if (socket == null)
                (new Socket(listener.getInetAddress, listener.getLocalPort)).close()
            if (socket != null)
                socket.close()
            listener.close()
        }
    }
}