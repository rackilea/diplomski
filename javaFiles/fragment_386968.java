@Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    if((Integer) view.getTag() == someTag){
        //doStuff
    } else if((Integer) view.getTag() == otherTag){
        //doOtherStuff
    } else{
        //andSomeOther
    }
}