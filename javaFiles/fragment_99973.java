String w = tx.getText();
            int p = Integer.parseInt(w);

            String e=String.valueOf(w);
    int m = e.length();
    System.out.println(m);

    if(e.length()==4){


             at.setText(""+p);
    }
    else{
        JOptionPane.showMessageDialog(null, "Wrong");
    }
        }   

    });