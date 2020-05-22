public class CustomAdapter extends ArrayAdapter<MyObject> {

private List<MyObject> list = new ArrayList<MyObject>();

public CustomAdapter(Context context, int resource) {
    super(context, resource);
}

 @Override
 public void add(MyObject obj) {
     this.list.add(obj);
     super.add(obj);
 }

 @Override
 public void remove(MyObject obj) {
     int i = getPosition(obj);
     if(i >= 0)
         list.remove(i);
     super.remove(obj);
 }

 @Override
 public void clear() {
     this.list.clear();
     super.clear();
 }

 @Override
 public MyObject getItem(int position) {
     return this.list.get(position);
 }

 @Override
 public int getPosition(MyObject obj) {
     for(int i = 0; i < list.size(); i++) {
         if(list.get(i).equals(obj))
             return i;
     }
     return -1;
 }}