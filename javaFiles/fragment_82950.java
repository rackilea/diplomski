for(int i=1; i<=10; i++) {
test = JOptionPane.showInputDialog(null, "nr "+ i +": enter number");
total += Integer.parseInt(test);
    }
JOptionPane.showMessageDialog(null, "total: " + total);
return;