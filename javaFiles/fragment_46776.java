File selectedFile;
        FileReader reader = null;
        BufferedReader in;
        try {
            final JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            txtSearch.setText((fc.showOpenDialog(CreateNode.this) == JFileChooser.APPROVE_OPTION) ? fc.getSelectedFile().toString() : txtSearch.getText());            
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                //gets file from dialog
                selectedFile = fc.getSelectedFile();
                //makes sure files can be processed before proceeding
                if (selectedFile.canRead() && selectedFile.exists()) {
                    //System.out.println("can read:"+selectedFile.canRead()+"exists:"+selectedFile.exists());
                    reader = new FileReader(selectedFile);

                }

            }
            in = new BufferedReader(reader);

            //inputLine recieves file text
            byte[] buffer;

            String inputLine = "";
             double port1 = Math.random();
        long portNo = Math.round(Math.random() * 10000);
                System.out.println("portNo"+portNo);
            int LineNumber = 0;
            while ((inputLine =in.readLine())!= null) {
                //LineNumber isn't needed, but it adds a line count on the left, nice
                LineNumber++;
               // StringTokenizer tokenizer = new StringTokenizer(inputLine);

                ServerSocket ss=new ServerSocket((int) portNo);
                Socket socket=new Socket("localhost",(int) portNo);


                //displays text file
                fileData.append(LineNumber + ": " + inputLine + "\n");

             //   System.out.println("connected:"+socket.isConnected());

                 // ss.accept();
                DataOutputStream dos4=new DataOutputStream(socket.getOutputStream());
                //next line in File opened
                dos4.writeUTF(LineNumber + ": " + inputLine + "\n");
                dos4.close();
                socket.close();

                Socket socket1=ss.accept();


               DataInputStream inp=new DataInputStream(socket1.getInputStream());
                //String msg=inp.readUTF();
                //System.out.println("msg:"+msg);


               String input = (String)inp.readUTF();
                System.out.println("inputline from socket:"+input);

                inp.close();

                ss.close();

            }
            //close stream, files stops loading
            in.close();

// TODO add your handling code here:
    }                                        
    catch (Exception e) {

        System.out.println("Exception e:"+e);
        e.printStackTrace();
        }


    }