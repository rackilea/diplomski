for (Integer d : al){
                while (s.add(d) == false){ //replace if with while to keep looking for duplicate
                    JOptionPane.showMessageDialog(null,"Number " + d + " was duplicated in position " + al.lastIndexOf(d));
                    JOptionPane.showMessageDialog(null,"Replace new number"); 


//      al.set(d,[set the new value here]);
       }
  }