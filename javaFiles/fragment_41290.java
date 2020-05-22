int count = 1;
for (int i = 0; i < flowerPack.length - 1; i++) 
{       
    if (flowerPack[i] != null)
    {           
        if (flowerPack[i].equalsIgnoreCase(flowerPack[i+1]))
        {               
            count++;
        }   
        else
        {
            System.out.println(flowerPack[i] + "s - " + count);
            count = 1;
        }
    }
    else
    {
        if (flowerPack[i] == null)
        {
            break;  
        }
    }
 }