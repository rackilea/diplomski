public static double getDiscountPercent(CustomerType ct) {

      double discountPercent = 0;

      switch(ct) {
         case CustomerType.RETAIL :
            discountPercent = 0.156;
            break;
         case CustomerType.TRADE :
            discountPercent = 0.30;
            break;
         case CustomerType.COLLEGE :
            discountPercent = 0.20;
            break;
         default :
            discountPercent = 0;
      }
      return discountPercent;

   }