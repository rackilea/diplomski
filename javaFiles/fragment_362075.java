ActionBar actionBar = getSupportActionBar();

if (actionBar != null)
{
   ......
   actionBar.setDisplayHomeAsUpEnabled(true); //Set this to true if selecting "home" returns up by a single level in your UI rather than back to the top level or front page.
   actionBar.setHomeAsUpIndicator(R.drawable.Your_Icon); // set a custom icon for the default home button
}