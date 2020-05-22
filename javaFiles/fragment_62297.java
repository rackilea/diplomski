tp: for (;;)  //<-- similar to while(true)
    {
        i++; //increases i by 1
        for (;;)  //<-- similar to while(true)
        {
            if (i > --j) { //decreases j and compares its value against i
                break tp; //breaks tp, which means breaking the outer for loop
            }
        }
        //while(true) above
        //if break gets executed, it breaks this for loop
        //so this line can never be executed
        System.out.println("i =" + i + ", j = " + j);
    }