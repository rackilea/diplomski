ThreadDemo T1 = new ThreadDemo( "Coupon-code");
 T1.start();
 String coupon = "";
 while(coupon.equals("")) //<-This can be tweaked in 
                          //order to consume less memory and be faster
     coupon=T1.getCoupon();