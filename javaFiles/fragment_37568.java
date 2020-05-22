int count = 0;
while(true) { 
    try {
        String newname = JOptionPane.showInputDialog("Enter in a name");
        if (newname.equals("@@@"))
            break;
        count++;
    }catch (Exception e) {
        //do something rational
    }
}
System.out.println(count);//change this as you wish