Player p ;
  FileConnection connection = (FileConnection) Connector.open("file:///M:/sampleVideo/file1.mpg");
        // If you run on the simulator then it is memorycard and if it device then it is specific to that device
       // FileConnection connection = (FileConnection) Connector.open("file:///memorycard/sampleVideo/6.mp4");
                                InputStream inStream = null;
                                inStream = connection.openInputStream();
                                try {
                                    p = Manager.createPlayer(inStream, "video/mpg");
                                    p.addPlayerListener(this);
                                   p.realize();