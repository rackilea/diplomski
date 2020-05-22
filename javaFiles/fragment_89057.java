public void actionPerformed (ActionEvent event)
    {
        Object source = event.getSource();
        if(source==b1){
             if(b1.isSelected()){
                 music[1].play();
             }
             else{
                 music[1].stop()
             }
        }

    }