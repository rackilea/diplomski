for(imgbt=0; imgbt<5; imgbt++){
    public final someInteger = imgbt;
    img [imgbt].setOnClickListener(
           new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(bool [someInteger] == false) {
                        bool [someInteger] = true;
                    }
                    else{
                        bool [someInteger] = false;
                    }
              }
         }
    );
}