package com.example.calentadorsolar;

import android.hardware.usb.*;
import android.os.Handler;
import android.os.Message;

public class Lectura_Solar implements Runnable
{
private UsbDeviceConnection connection;
private UsbEndpoint epIN;
private Handler handler;
private UsbInterface intf;
private Datos_Solar aux;

public Lectura_Solar(UsbDeviceConnection connection,UsbInterface intf,UsbEndpoint epIN, Handler   handler)
{
    this.connection = connection;
    this.epIN = epIN;
    this.handler = handler;
    this.intf = intf;
    aux = new Datos_Solar();
}



public void run()
{
    connection.claimInterface(intf,true);
    connection.controlTransfer(0x21, 34, 0, 0, null, 0, 0);
    connection.controlTransfer(0x21, 32, 0, 0, new byte[] { (byte) 0x80,
                    0x25, 0x00, 0x00, 0x00, 0x00, 0x08 }, 7, 0);
    byte datos [] = new byte[64];
    while (true)
    {
        int data = connection.bulkTransfer(epIN, datos, datos.length, 5000);
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e){}
        if (datos[0] == 0)
        {
            aux.temp1 = String.valueOf(datos[1]);
            aux.temp2 = String.valueOf(datos[2]);
            aux.temp3 = String.valueOf(datos[3]);
            aux.temp4 = String.valueOf(datos[4]);
            this.sendMessage(aux);//here we send the data to the main GUI
        }

    }
}

public void sendMessage(Datos_Solar message)
   {
    Message sms = new Message();
    sms.obj = message;
    handler.sendMessage(sms);
   }
  }