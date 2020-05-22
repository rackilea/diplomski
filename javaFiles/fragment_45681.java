List<FeeAccount> feeAccounts = 
    contractList.stream()
                .flatMap(contract -> {
                    List<Fee> monthlyFees=...;
                    return monthlyFees.stream()
                                      .map(monthlyFee -> {
                                          FeeAccount account = new FeeAccount();
                                          account.setFeeCode(monthlyFee.getFeeCode());
                                          account.setDebtorAccount(contract.getDebtorAccount());
                                          return account;
                                      });
                })
                .collect(Collectors.toList();