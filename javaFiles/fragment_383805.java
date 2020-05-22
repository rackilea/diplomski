private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

        Timer t = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("J = " + j);  //for debugging
               // System.out.println("I = " + i);
                if(j >= CERT[i].length()){
                    j = 0;
                    i++;
                    jTextArea1.setText(jTextArea1.getText() + "\n");

                }

              if(i >= CERT.length) ((Timer)e.getSource()).stop();
              else{
                  jTextArea1.setText(jTextArea1.getText() + CERT[i].charAt(j));
                  j++;
              }
            }
        });
        t.setRepeats(true);
        t.start();
    }