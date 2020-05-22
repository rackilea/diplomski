for(n=0;n<6;n++){
    // other code
    for(w=n;w<6;w++){
    // if w==4 then go to first loop an continue from n=4!!
        if (w == 4) {
            n = 4;
            break;
        }
    }
    // other code
}