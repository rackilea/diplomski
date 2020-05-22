sumQuan = 0;
for(int i = 0; i < len; i++)
{
    if(calc[i].equals("1"))
    {
        sumQuan = sumQuan+quantity[i];                                                       
    }                             
    // we don't need to do anything if it's "0"
    if ((i < material.length-1 && material[i+1] != material[i])
         || (i == material.length-1)) {
        System.out.println(sumQuan);
        sumQuan = 0;
    }

}