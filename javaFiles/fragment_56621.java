if (bline.length < 3)
{
    int column = 0;
    for(int i = 0; i<bline.length; i++){
        column = i;
        if(bline[i] == null || bline[i].trim() == ""){
            System.out.println("There is an error in row two column "+(i+1));
        }
    }
 }