public class function implements OnItemSelectedListener {

   private final static int[] grades = new int[]{20,40,60,80,100}; //change in whatever you want. The length of the array must be the same of the adapter, or an ArrayIndexOutOfBoundException may be throwed.

   @Override
   public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
       text.setText(grades[pos] + " points!");
   }
}