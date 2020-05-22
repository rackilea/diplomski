if (buttons[row][col].isOver()) {
    try {
        if (list.contains(Integer.parseInt(buttons[row][col].getName()))) {
            if(Integer.parseInt(buttons[row][col].getName()) == list.get(list.size() - 2)) {
                stage.getRoot().findActor("" + list.get(list.size() - 1)).setColor(Color.WHITE);
                list.remove(list.size() - 1);
            }
        } else {
            buttons[row][col].setColor(Color.GREEN);
            list.add(Integer.parseInt(buttons[row][col].getName()));
        }
      } catch (Exception e) {
           System.out.println(e.getClass());
      }
}