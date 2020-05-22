@Override
public int getItemViewType(int position) {

    if(position == 0){    //for layout1
        return 1;
    }else{
        return 2;        //for layout2
    }
}