public void updateData(){
   ArrayList<String> strs=new ArrayList<String>();
   String mealsnames[]=new String[meals.size()];
   for(int i=0;i<meals.size();i++)strs.add(meals.get(i).getName());
   strs.toArray(mealsnames);
   Log.i("debug","meals ou size "+meals.size());
   CustomList  adapter = new CustomList(getActivity(),mealsnames,meals);
   List = (ListView)view.findViewById(R.id.list);
   List.setAdapter(adapter);
}