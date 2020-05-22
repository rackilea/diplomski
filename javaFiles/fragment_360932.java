public static long Id;
@BeforeClass public static void onlyOnce() {
    transactionVO transactionVO = new TransactionVO();
    transactionVO.setTransactionId(transactionId);
    transactionVO.setUniqueKey(uniqueKey);
    transactionVO.setCreationDate(Calendar.getInstance());
    transactionVO vo = daoImpl.saveTransaction(transactionVO);
    Id = vo.getId(); // Here Id is setting to some value like 775
}