int count = mainLinearLayout.getChildCount();
View view = null;
for(int countI=0; countI<count; countI++) {
    view = layout.getChildAt(countI);
    if(((int) view.getTag()) == ((int) v.getTag())){
        mainLinearLayout.removeView(view);
        break;
    }
}