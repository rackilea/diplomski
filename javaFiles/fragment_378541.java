boolean branchFound = false;
for(int i=0;i<branchList.length;i++)
{
    if(branchList[i]==branchId)
    { 
        branchFound = true;
        fees1=fees[i];
        reg.setFees(fees1);
        System.out.println("The Registration ID is:"+reg.getRegistrationId());
        System.out.println("The fees before discount is:"+reg.getFees());
        reg.calculateFees(79);
        break;
    } 
   }
  }
}
if (!branchFound) {
    System.out.println("Invalid branch ID");
}