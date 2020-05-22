else if(e.getSource()==b4){
            double i1,i2;
            i1= Integer.parseInt(t1.getText());
            i2= Integer.parseInt(t2.getText());
            if(i1!=0 && i2 == 0){
                throw new ArithmeticException();
            }
            else if(i2 == 0 && i1 == 0) {
                throw new ArithmeticException();
            }
            i1= i1/i2;
            l7.setText(i1+"");
        }