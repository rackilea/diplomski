public class YourActivity extends AppCompatActivity implements ItemClickListener {
     ....
     ....
     protected void onCreate(Bundle savedInstanceState) {
          ...
          ...
     }

     @Override
     public void onRecyclerViewItemClicked(int position) {
          //You will get the position of the Item Clicked over recycler view
          //You can handle as per your requirement
     }
}