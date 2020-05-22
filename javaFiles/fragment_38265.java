countries.addListener(new ListChangeListener<Country>()
{
   @Override
   public void onChanged(ListChangeListener.Change<? extends Country> change)
   {
      while (change.next())
      {
          if (change.wasAdded())
          {
             if (flow == null) { return; }
             int first = flow.getFirstVisibleCell().getIndex();
             int last = flow.getLastVisibleCell().getIndex();
             int selected = tableView.getSelectionModel().getSelectedIndex();

             if (selected < first || selected > last)
             {
                flow.show(selected);
             }
          }
       }
   }
});