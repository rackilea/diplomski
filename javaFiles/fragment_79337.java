String[] object = new String[7];
//...read...
    String x = line + ",";
    int iPos = 0;
    int iStr = 0; 
    int iNext = -1;
    while( (iNext = x.indexOf( ',', iPos )) != -1 && iStr < 7 ){
        if( iNext == iPos ){
            object[iStr++] = "NA";
        } else {
             object[iStr++] = x.substring( iPos, iNext );
        }
        iPos = iNext + 1;
    }
    // add more "NA" if rows can have less than 7 cells