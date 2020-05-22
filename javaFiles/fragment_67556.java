for(int i=0; i<elements.size();i++){
        String check_state= elements.get(i).getAttribute("checked");
        if(check_state == null){
            System.out.println("Checbox "+(i+1)+" is not selected");
        }
    }