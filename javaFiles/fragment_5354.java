TextView textView = (TextView) view.findViewById(R.id.customName);
// get Text from entry and pass it to setText method
String strTextViewData=entry.getItem()...;
textView.setText(strTextViewData); 
if(entry.getItem().isBought()) {
 textView.setBackgroundColor(Color.BLUE);
}