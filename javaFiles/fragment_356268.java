try
    {
        InetAddress host = InetAddress.getByName("localhost") ;
        socket = new DatagramSocket() ;

        byte [] data = "stats\r\n".getBytes() ;
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.putShort((short)0);
        buffer.putShort((short) 0x0000;);
        buffer.putShort((short) 0x0001;);
        buffer.putShort((short) 0x0000;);
        buffer.put(data);
        DatagramPacket packet = new DatagramPacket( buffer.array(), buffer.array().length, host, 11211 ) ;
        socket.send( packet) ;
        socket.setSoTimeout( 2000 ) ;
        packet.setData( new byte[1024] ) ;
        socket.receive( packet ) ;
        System.out.println( new String(packet.getData()) ) ;

    }
    catch( Exception e )
    {
       e.printStackTrace();
    }
    finally
    {
        if( socket != null )
            socket.close() ;
    }