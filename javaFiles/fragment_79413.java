ArrayList<String[]> list = new ArrayList<String[]>(6);
String[] splitted;
String line;
for(int i=0;i<6;i++) {
    line = JOptionPane.showInputDialog("Please enter tutor name and their highest earned degree.");
    splitted = line.split("\\s+");
    list.add(splitted);
}

for(int i=0;i<6;i++)
    System.out.println(Arrays.deepToString(list.get(i))); //Will print all 6 pairs