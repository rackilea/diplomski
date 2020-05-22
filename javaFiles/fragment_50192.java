String numbers = "71 17 -93 -104";
    String[] nums = numbers.split(" ");
    for(int i=0; i< nums.length; i++)
    {
        System.out.println(nums[i]); 
    }
    int StrArrLen = nums.length;
    byte[] myArray = new byte[StrArrLen];
    for(int i=0; i< StrArrLen; i++)
    {
        myArray[i] = (byte)Integer.parseInt(nums[i]);

    }
    System.out.println("\nResult:");
    for(int i=0; i< StrArrLen; i++)
    {
        System.out.println(myArray[i]); 
    }