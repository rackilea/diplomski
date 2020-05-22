for(int x =0;x<TeamPlayercmbx.length;x++)
{
      if(e.getSource()==TeamPlayercmbx[x])
      {
            try
            {
                 ArrayList <String> Competitors = new ArrayList();
                 for(int i=0;i<TeamPlayercmbx[x].getItemCount();i++)
                 {               
                       Competitors.add(TeamPlayercmbx[x].getItemAt(i).toString());
                 }
                 DefaultComboBoxModel DCMB = new 
                 DefaultComboBoxModel(Competitors.toArray());
                 TeamPlayercmbx[x+1].setEditable(true);
                 TeamPlayercmbx[x+1].setModel(DCMB);
                 TeamPlayercmbx[x+1].removeItem(TeamPlayercmbx[x].getSelectedItem());
                 }
            catch(Exception ex)
            {
            }
     }
}