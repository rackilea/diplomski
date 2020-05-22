public GroupAccount(long groupAccountId,
                  long adminId,
                  String accountName,
                  String accountDescription,
                  int numberOfMembers,
                  BigDecimal totalAmountPaid,
                  BigDecimal totalAmountOwed,
                  int testResourceId) {

this.groupAccountId = groupAccountId;
this.adminId = adminId;
this.accountName = accountName;
this.accountDescription = accountDescription;
this.numberOfMembers = numberOfMembers;
this.totalAmountPaid = totalAmountPaid;
this.totalAmountOwed = totalAmountOwed;
this.testResourceId = testResourceId; 
}