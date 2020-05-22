public class SlidingTabLayout extends HorizontalScrollView {



    /**
    * #####################Add THIS METHOD ############
    *
    * @param layoutResId Layout id to be inflated
    * @param textViewId  id of the {@link TextView} in the inflated view
    */
   public void setCustomTabView (int layoutResId, int textViewId) {
       mTabViewLayoutId = layoutResId;
       mTabViewTextViewId = textViewId;
   }
...
}