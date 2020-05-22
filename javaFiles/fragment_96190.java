class myBaseAdapter extends BaseAdapter{
      private ArrayList<HashMap<String,Object>> cAndr;
      private LayoutInflater mInflater;
      //.... Other stuff here
      public void clear(){
          cAndr.clear();
      }
}