for(int i=0; i<=numberOfItems; i++)
    {
       System.out.println("Enter product name (or STOP to stop)");
       String tmpProduct = input.nextLine();

       //trim to avoid whitespace
       if ("STOP".equals(tmpProduct.trim())) {
          break; //we stop the loop here
       }

       //they didn't type STOP, guess they wanted a product.
       productName[i]=tmpProduct;


       System.out.println("Enter price of product");
       productPrice[i]=input.nextDouble();
       System.out.printf("%s,%n,%.2f",productName[i],productPrice[i]);
    }