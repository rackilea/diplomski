String haspaper="" ;
    if(yes3.isSelected()){
        if(checkcontract.isSelected()){
             haspaper = haspaper + checkcontract.getText()+",";
        }
        else if(checkcivile.isSelected()){
             haspaper = haspaper + checkcivile.getText()+" , ";
        }
        else if(checkcontartpar.isSelected()){
             haspaper = haspaper + checkcontartpar.getText()+" ,";
        }
        else {
             haspaper = haspaper + mahiyapaper.getText()+" ,";
        }
    }else{
         haspaper=no3.getText();
    }