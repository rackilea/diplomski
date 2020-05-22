btnOblicz.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

          int selectedP = spinnerP.getSelectedItemPosition();
          int selectedD = spinnerD.getSelectedItemPosition();        

          switch(selectedP){
             case 0:
                  switch(selectedD){
                       case 1:
                            convertFrom0to1();
                            break;
                       case 2:
                            convertFrom0to2();
                       ....
                   }
                   break;
            ....
           }
    }
});