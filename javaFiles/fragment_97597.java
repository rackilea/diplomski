StringBuilder message = new StringBuilder();
for (int i = 0; i < 5; i++) {
    message.append(inputDie1[i].getValue1() + "   " + inputDie2[i].getValue2() + "\n");
}

JOptionPane.showMessageDialog(null, message.toString());