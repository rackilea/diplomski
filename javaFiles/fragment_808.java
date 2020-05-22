public class YourActivity extends Activity
        implements YourFragment.FragmentListener {

  ...

  @Ovveride
  public void onRecyclerViewItemClicked(int position) {
    // Handle the RecyclerView item click here
    switch(position) {
      case 0:
        showInterstitial();
        break;
     default:
       intent = new Intent(this, AllBlock.class);
       startActivity(intent);
    }
  }
}