@Override
public int getItemViewType(int pos){
    if((pos + 1) % 6 == 0){
        return VIEW_B;
    }else{
        return VIEW_A;
    }
}