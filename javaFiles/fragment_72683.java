private void femminaActionPerformed(java.awt.event.ActionEvent evt) {                                        
    if(femmina.isSelected()){
        if(sexint==0){
          sexint++;
          sexone=femmina.getText();    
        }
        else if(sexint==1){
            sexint++;
        sextwo=femmina.getText();
        }
        else
            sexint--;

    System.out.println(sexint);        
    }
}                                       

private void maschioActionPerformed(java.awt.event.ActionEvent evt) {       
    if(maschio.isSelected()){
        if(sexint==0){
          sexint++;
          sexone=maschio.getText();
        }
        else if(sexint==1){
            sexint++;
        sextwo=maschio.getText();
        }
        else
            sexint--;

    System.out.println(sexint);
    }
}