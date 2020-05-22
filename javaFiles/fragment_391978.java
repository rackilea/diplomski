for(int n = 0;n<list.size(); i++) {
    for(int m = n+1;m<list.size(); m++) {  //m=n+1 : guarantee unique
        for(int k = m+1;k<list.size(); k++) {  //k=m+1 : guarantee unique
            if (
                list.get(n).intersectsLine(list.get(m))  &&
                list.get(m).intersectsLine(list.get(k))  &&
                list.get(n).intersectsLine(list.get(k))  
            ) {
                 amountOfTriangle++;
            }
        }
    }
}