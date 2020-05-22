//In BubbleSortAsc
            result=names[i].compareToIgnoreCase(names[i]);
            //result == 0, since names[i] is definitely equal to names[i]
            if(result>0)
            {
                //Never reached
                temp=names[i-1];
                names[i-1]=names[i];
                names[i]=temp;
            }