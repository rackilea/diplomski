for(int i = 0; i < vMem.length; i++)
{
     vMem[i] = input.nextInt();
     storeMem.write(i);
     if(i > vMem.length)
     {
          System.out.println("out of bounds!");  
     }
 }