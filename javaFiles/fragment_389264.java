InputStream is = clientSocket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        System.out.println("Message received from client is "+data);
        if("send_players".equals(data)){ // reading data you would need to finetune
          //write playerlist
        }