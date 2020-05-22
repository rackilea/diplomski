lst.addListSelectionListener(new ListSelectionListener() {

     @Override
     public void valueChanged(ListSelectionEvent e) {
         if (e.getValueIsAdjusting()) {
              JList list = (JList)e.getSource();
              DefaultListModel model = (DefaultListModel)list.getModel();
              ElementDisplay ed = (ElementDisplay) model.getElementAt(lst.getSelectedIndex());
              System.out.println(ed.elementID);
         }
     }
 });