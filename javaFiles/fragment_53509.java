public class MainActivity extends AppCompatActivity { 
    // ...
    void ShowItemDetails(String mCategory, Item mItem){
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("dataString", mItem.GetDataString());
        startActivity(intent);
     }
}