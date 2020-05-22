private ClickListener clickListener;

public void setExamine(final ClickListener cl) {
   if(clickListener != null) {
      examine.removeListener(clickListener);
   }
   examine.addListener(cl);
   clickListener = cl;
}