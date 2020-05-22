for (int i = 0; i < output.length();){
   rooms[i] = output.split(",");
   i++;
}

results.setModel(new DefaultTableModel(rooms,columnNames )