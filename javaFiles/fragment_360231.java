String str = cell.getReference();
    for(index = 0;index<str.length();index++){
        if((int)str.charAt(index)<65){
            break;
        }
    }
    String Col = str.substring(0, index);
    String Row = str.substring(index+1, str.length());