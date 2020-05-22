JTextArea txtarea=new JTextArea(5,30);                    
    String str=txtarea.getText();
                        String[] temp;
                        String delimiter = "\\n";
                        temp = str.split(delimiter);
                      for(int i =0; i < temp.length ; i++)
                        System.out.println(temp[i]);