if (str.contains(firstLetter)) {
        index1=str.indexOf(firstLetter);
        if (str.contains(secondLetter) && str.indexOf(secondLetter)>index1){
           index2=str.indexOf(secondLetter);
           if (str.contains(thirdLetter) && str.indexOf(thirdLetter)> index2)        {
               System.out.println(str);
               counter++;
           }
        }
    }