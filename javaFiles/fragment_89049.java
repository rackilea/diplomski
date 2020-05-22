for(int i=0; i<=numberOfItems; i++)
    {
       System.out.println("Enter product name");

       //they didn't type STOP, guess they wanted a product.
       productName[i]=input.nextLine();

       System.out.println("Enter price of product");
       productPrice[i]=input.nextDouble();
       System.out.printf("%s,%n,%.2f",productName[i],productPrice[i]);

       System.out.println("type STOP to stop or anything else to continue");
       String tmp = input.nextLine();
       //trim to avoid whitespace problems
       if ("STOP".equals(tmp.trim())) {
          break; //we stop the loop here
       }
    }