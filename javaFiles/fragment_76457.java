public void buttonClick(View yourButton){
    if(yourButton.getTag() == null){ //We have no tags, so first click :)
        yourButton.setTag(1);
    }

    if((Integer)yourButton.getTag() == 3){
        //Do whatever
    }else{
        //Increment the value of the tag
        yourButton.setTag(((Integer)yourButton.getTag())+1);
    }
}