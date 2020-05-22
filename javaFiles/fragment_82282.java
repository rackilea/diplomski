RelativeLayout relHeader, relFooter, relContent;

public RelativeLayout createDesign(RelativeLayout rel2MainActivity, Context context) {

  rel2MainActivity = new RelativeLayout(context);
  // ...
  rel2MainActivity.addView(relHeader, 0);
  rel2MainActivity.addView(relContent, 1);
  rel2MainActivity.addView(relFooter, 2);
  // rel2MainActivity has 3 children in debug 
   // rel2MainActivity view is local to this scope
   // you should return it
   return rel2MainActivity;


}