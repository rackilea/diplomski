String[] options = {"Pizza", "Hot Dog"};

final String food = (String) JOptionPane.showInputDialog(null, "Choose a food", "Food", JOptionPane.QUESTION_MESSAGE, null, options, "Pizza");

StringBuilder sb = new StringBuilder();
sb.append(System.getenv("APPDATA"));
sb.append(File.separator);
sb.append(food);
sb.append(".txt");
System.out.println(sb.toString());