@Override
public void onBackPressed() 
{
  if(getFragmentManager().getBackStackEntryCount() > 0)
    getFragmentManager().popBackStack();
  else
   super.onBackPressed();
}