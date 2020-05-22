public Payment createPayment(

    List<StsTxn> collect = externalPayments.stream().map(
    t -> {
    Payment payment = new Payment();
    try {
           BeanUtils.copyProperties(payment, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
           logger.error(e.getMessage(), e);
    }
    return payment;
 })