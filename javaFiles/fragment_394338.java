@Override 
 protected void onPostExecute(List<Cours> laliste)
  {
      if(dialog.isShowing()) 
      { 
           dialog.dismiss(); 
       } 
      for (Cours c : laliste)
      {
        System.out.println(c.toString()); 
      } 

     MyAdapter adapter = new MyAdapter(laliste);
     rv.setAdapter(adapter);
     rv.notifyDataSetChanged();
   }