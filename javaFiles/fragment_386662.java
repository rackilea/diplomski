one:while(true)
    {
        str = clientStream.readLine();
        b =str.getBytes();
        bos.write(b);
        bos.flush();

        while (bis.available() <= 0)
        {
            // wait for data!
        }

        a=bis.available();
        b = new byte[a];
        bis.read(b);
        str = new String (b);
        str.trim();
        System.out.print("The server says: "+str);
        if (str.equals("BYE"))
        {
            bis.read(b);
            str = new String (b);
            System.out.print("The server says: "+str);
            break one;
        }
    }