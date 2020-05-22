TextView textView = null; 
    ViewGroup row = (ViewGroup) v.getParent();
    for (int itemPos = 0; itemPos < row.getChildCount(); itemPos++) {
        View view = row.getChildAt(itemPos);
 if (view instanceof TextView) { //do a getTag here and get the textView you need
             textView = (TextView) view; //Found it!
             break;
        }
    }