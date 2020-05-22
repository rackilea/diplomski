while(true)
{
     int i = input.nextInt();
     if(i > vMem.length)
        throw new ArrayindexOutofBoundsException();

     vMem[i] = data;
}