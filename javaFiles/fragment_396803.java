backwardButton.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
          int sizeHistory = engine.getHistory().getEntries().size();
          if(sizeHistory>1)
          {
              Entry entry = engine.getHistory().getEntries().get(sizeHistory-2);
              System.out.println("URL hist.: " + entry.getUrl());
              loadURL(entry.getUrl());
          }
        }
     });