if(arg0.getId()==R.id.btnprevious){
        screennumber--;//minus 1 to the screennumber
        changeNumber(screennumber);
        if(screennumber==0){
            //disable btnprevious
            btnprevious.setEnabled(false);
        }else{
            //enable btnprevious
            btnprevious.setEnabled(true);
        }
        changeNumber(screennumber);
        btnnext.setEnabled(true);
    }