.forEach(pp->{
    if(pp instanceof Pane){
        ((Pane) pp).setBackground(colorOther)
    }else{
        ((Text) pp).setFill(colorText);
    }
});