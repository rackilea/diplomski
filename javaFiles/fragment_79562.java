public class YourActivity extends AppCompatActivity implements OnFragmentTitleChangeListener
{
  TextView title;
  ......
  ......
  // Initialize title in onCreate method
  ......
  ......
  // Override this method
  public void onFragmentTitle(String strTitle) 
  {
      title.setText(strTitle);
  }

  @Override
  public void onBackPressed() {
    FragmentManager fm = getSupportFragmentManager();

    if (onBack(fm)) {
        return;
    }
    super.onBackPressed();
  }

  private boolean onBack(FragmentManager fm) {
     if (fm != null) {
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            return true;
        }
    }
    return false;
  }
}