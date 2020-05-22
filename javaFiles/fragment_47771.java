btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                    
                try {
                    URL videoURL = new URL(urlString);
                    URLConnection videoConnection = videoURL.openConnection();
                    videoConnection.connect();
                    openWebpage(videoURL);
                } 
                catch (MalformedURLException mue) {} 
                catch (IOException ioe) {}
                setEnabled(false);
            }
        });