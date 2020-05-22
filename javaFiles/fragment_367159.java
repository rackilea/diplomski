private void checkInternetConnection(){      
        try {
            Process proccess = java.lang.Runtime.getRuntime().exec("ping varzesh3.com");
            int result = proccess.waitFor();
            if(result == 0){
                lblStatus.setForeground(Color.blue);
                lblStatus.setText("اینترنت فعال است");
                timer.stop();
            }
            else{
                lblStatus.setForeground(Color.red);
                lblStatus.setText("اینترنت غیر فعال است"); 
            }

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(InternetChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }