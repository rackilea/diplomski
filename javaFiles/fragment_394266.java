if(!valueList.isEmpty()){
    int lastValue=valueList.get(valueList.size()-1);
    sum=sum-lastValue;
    valueList.remove(valueList.size()-1);
    textViewamount.setText(Integer.toString(sum));
}