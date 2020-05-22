// childCount is for ViewGroup only, if problem still occurs you can
// check first if v object really is a ViewGroup instance with the
// below instanceof check
if( v instanceof ViewGroup && parent instanceof ViewGroup && ((ViewGroup)v).getChildCount()!=0 ){

     // perform the cast only once, also now we know it's safe thanks to the instanceof
     ViewGroup vg = (ViewGroup)v

     View nextChild = vg.getChildAt(0);
     Log.i("child", vg.getChildCount()+"");   

     // no guarantee here whatever that parent is a more specific ViewGroup
     // so if we need this to be a ViewGroup we'll have to cast but check
    // with instanceof first
    ((ViewGroup)parent).addView(nextChild); //this was the error line

     View view = (View) event.getLocalState();
     ViewGroup viewgroup = (ViewGroup) view.getParent();
     viewgroup.removeView(view);
     RelativeLayout containView = (RelativeLayout) v;
     containView.addView(view);
     view.setVisibility(View.VISIBLE);

} else {
     // PERFORM SOME LOGGING HERE
     // so you know what views got dropped in here that didn't match your requirements in the first place
     // TODO

}