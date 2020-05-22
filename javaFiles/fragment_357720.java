for(int i=0; i < exp.length; i++){
    ch = exp[i];
    if(Character.isDigit(ch)){
        convert = (int)ch-'0';
        op.push(convert);
        convert = 0;
    }