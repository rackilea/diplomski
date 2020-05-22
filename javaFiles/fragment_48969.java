float f1 = 0.0410f;
    float f2 = 123456789010L;
    System.out.println(new BigDecimal(f1)); // 0.041000001132488250732421875
    System.out.println(new BigDecimal(f2)); // 123456790528
    System.out.println(new BigDecimal(0.0410f * 123456789010L)); // 5061728768
    System.out.println(new BigDecimal(f1 * f2)); // 5061728768