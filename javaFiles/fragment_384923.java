Chase.getBranchList().get(Chase.branchIndex(branch))
                     .getCustomerList()
                     .get(Chase.getBranchList()
                         .get(Chase.branchIndex(branch))
                         .customerIndex(name))
                     .addTransaction(amount);