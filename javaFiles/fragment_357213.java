while ((one = comone.readLine()) != null) { 

    a= -111111;
    comtwo.mark(someInt); // basically just the length you expect to read in comtwo
    while ((two = comtwo.readLine()) != null) { 


    if(one.equals(two) == false)
        {
            a =1;
        }
    else
        {
            a=0;
            break;

        }               
    }
    comtwo.reset();

    if(a==1)
    {   
        System.out.println("Check this name : "+one);
    }   
}