class Listener1 implements ActionListener{
        public void actionPerformed (ActionEvent e){

            for(int a = 0; a<strArray.length; a++){
                strArray[a] = "";
                if(e.getSource() == coke){
                    total += 1.5;
                    strArray[a] = "Coke";
                    System.out.println(strArray[a]);
                    orderArea.setText(strArray1);
                    break;

                } else if(e.getSource() ==milk){
                    total += 1.00;
                    String milk1 = "Milk - $1.00";
                    System.out.println(milk1);
                    strArray[a] = milk1;
                    orderArea.setText(strArray1);
                    break;
                }
            }

        }