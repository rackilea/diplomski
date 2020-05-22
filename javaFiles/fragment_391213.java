if ((withdraw % 5 == 0) && (acnt_balc >= withdraw + 0.50)) {
    double cur = acnt_balc - (withdraw + 0.50);
    System.out.println(cur);
} else {
    System.out.println(acnt_balc);
}