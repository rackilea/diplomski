List<Integer> numList = new ArrayList<>();
  numList.add(Integer.parseInt(JOptionPane.showInputDialog("Write a number.")));
  numList.add(Integer.parseInt(JOptionPane.showInputDialog("Write a number.")));
  numList.add(Integer.parseInt(JOptionPane.showInputDialog("Write a number.")));
  numList.add(Integer.parseInt(JOptionPane.showInputDialog("Write a number.")));

    for (Integer i :numList) {
        if (i < 0) {
            System.out.println("Number " + i + " is negative.");
            break;
        }
        if (i > 0) {
            System.out.println(i + " is a integer.");
        }
        if (i == 0) {
            System.out.println(i + " is zero.");
        }
    }