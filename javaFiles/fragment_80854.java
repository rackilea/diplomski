double sumTotal = 0;

for(String item : items){

     sumTotal += Double.parseDouble(item);//convert string to int
     //Its equals to sumTotal = sumTotal + Double.parseDouble(item);
}

JOptionPane.showMessageDialog(parent, "You Cashed Out with: "+sumTotal);