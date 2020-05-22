@Override
public void onClick(View view) {
    switch(view.getId()){
        case R.id.back:
            if(pos==0){
               pos=len;
                pos=pos-1;
                show.setText(nowdata[pos]);
            }
            else{
                pos=pos-1;

                show.setText(nowdata[pos]);
            }
            break;
        case R.id.next:
            pos=pos+1;
            if(pos>=len){
                pos=0;
            }

           show.setText(nowdata[pos]);



            break;
    }
}