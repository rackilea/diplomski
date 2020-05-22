if (str.contains(firstLetter)) {
        index1=str.indexOf(firstLetter);
        str=str.substring(0,index1)+'0'+str.substring(index1+1);
        if (str.contains(secondLetter) && str.indexOf(secondLetter)>index1){
           index2=str.indexOf(secondLetter);
           str=str.substring(0,index2)+'0'+str.substring(index2+1);
           if (str.contains(thirdLetter) && str.indexOf(thirdLetter)> index2)        {
               System.out.println(str);
               counter++;
           }
        }
    }