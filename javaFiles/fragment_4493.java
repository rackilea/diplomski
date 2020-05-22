departJList.addListSelectionListener(new ListSelectionListener() {

     public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {

           // ******* added **********
           ((JList)e.getSource()).removeListSelectionListener(this);

           TimeTable selected = new TimeTable();
           selected.setTimeTable();
           newListContent.addAll(selected.getTimeTable());
        }

        System.out.println(newListContent);
        departJList.setListData(newListContent);

     }
  });