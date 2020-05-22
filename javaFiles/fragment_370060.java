package com.example

import java.net.Socket
import java.net.URL

object CLI extends App {
    val addr = args(0) // The server address (example.com:8080)

    val addrUrl = new URL("http://" + addr + "/~cli/addr")
    var con = addrUrl.openConnection()
    var in = con.getInputStream()
    var cliAddr = ""
    while (in.available() > 0)
        cliAddr += in.read.toChar

    val portUrl = new URL("http://" + addr + "/~cli/port")
    con = portUrl.openConnection()
    in = con.getInputStream()
    var cliPort = ""
    while (in.available() > 0)
        cliPort += in.read.toChar

    val socket = new Socket(cliAddr, Integer.valueOf(cliPort))

    implicit def stringToByteArray(s: String) = s.toCharArray.map(c => c.toByte)

    socket.getOutputStream().write("Hellllo from CLI process")
}