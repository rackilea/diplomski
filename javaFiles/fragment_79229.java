int clientNumber = 0;
  TreeMap buttonsMap = new TreeMap();
  buttonListener blistener = new buttonListener();
  void connect_clients()
    {
        try {
            ServerSocket listener = new ServerSocket(7700);
            jButton2.setText("Server Running!");
            jButton2.setEnabled(false);
            try {
                while (true) {

                    Socket socket = listener.accept();
                    try {

                         //  System.out.println("Client connected from " + socket.getLocalAddress().getHostName());
                         String clientIP= socket.getLocalAddress().getHostName();
                         JButton button = new JButton(clientIP);
                        button.addActionListener(blistner);
                         buttonsMap.put(button, socket);
                         displayButton(button,clientNumber);
                         clientNumber++;

                 } 
                 catch(Exception e)
                 {
                 }
               }
            }
            finally {
                listener.close();
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Test_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



private class buttonListener implements ActionListener
  {  
    public void actionPerformed( ActionEvent e ) throws IOException{
        if ( JButton button= e.getSource())
        {
            Socket socket = (Socket)buttonsMap.get(button);
            PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);

                             out.println("hey");
                             JOptionPane.showMessageDialog(null,"gfb");
        }
      }
    }