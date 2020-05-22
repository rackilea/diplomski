// Declare in correct scope and define later...
ViewGroup.LayoutParams layoutParams;

// If the parent is a viewpager
if (parentIsViewPager)
{
    // Retrieve the view's layout informations specific to viewpagers
    layoutParams = (ViewGroup.LayoutParams) getLayoutParams();
}
// If the parent is not a viewpager (mainly a viewgroup)
else
{
    // Retrieve the view's layout informations for a viewgroup
    layoutParams = (ViewGroup.LayoutParams) getLayoutParams();
}

Log.i("Test","layoutParams.width = " + layoutParams.width);