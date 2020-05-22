for(i = 0;i < len;i++)
{ 
        k=0;
        for(j = 0;j <= len-i;j++,k++)
        {   System.out.println("i :"+i);
            System.out.println("j :"+j);
            sub = word.substring(i, i+j);
            System.out.println("k :"+k);
             res[k] = sub;
            //for(k = 0;k < res.length;k++)


        }
}