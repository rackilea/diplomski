@RequestMapping(value = "/completePayment", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
  public boolean completePayment(@RequestParam("paymentID") String paymentId, @RequestParam("payerID") String payerID) {

    System.out.println("in completePayment");
    System.out.println(paymentId);
    System.out.println(payerID);
    return true;
  }