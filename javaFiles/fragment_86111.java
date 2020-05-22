public class RoleList extends ArrayAdapter<String>{
     //private String[] name;
     private ArrayList<String> name;      

     // it show how many items are in the data set represented by this Adapter.
     @Override
     public int getCount(){
           return name.size();
     }
}