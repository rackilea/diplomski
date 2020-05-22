color.add(new JMenuItem("Red")).addActionListener(evt -> {
   panel.setSelectColor(Color.RED);
   for(int i = 0 ; i < color.getItemCount(); i++){
    color.getItem(i).setEnabled(!evt.getSource().equals(color.getItem(i)));
   }
});