//MainActivity
private String mItem = "";

public void getItem(){
    return this.mItem;
}

public void addItem(String searchItem){
    this.mItem += searchItem;
}


//FRAGMENT 1
public void onButtonClick(){        
    //adding a string to your item in the MainActivity
    ((MainActivity)getActivity()).addItem("String from Frag1");

}



//FRAGMENT 4
private void onButtonClick{
    //reading the string
    String toastMessage =  ((MainActivity)getActivity()).getItem();
}