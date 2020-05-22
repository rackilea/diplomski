while(fromIndex>-1)         
            {         
                fromIndex = source.indexOf(test, fromIndex+1);         
                System.out.println("found at"+fromIndex);         
                if(fromIndex!=-1) occurences++;         
                }          
            }