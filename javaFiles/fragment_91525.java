@Transactional(
    propagation = Propagation.REQUIRED,
    readOnly = false,
    value="transactionManager",
    rollbackFor = {
       Exception.class
      })
public void insertStuff()