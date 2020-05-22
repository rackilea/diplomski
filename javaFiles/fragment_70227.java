class NprDto{
   Long accountId;
   .......

 @Override
 public boolean equals(Object obj) {
   NproDto other=(NproDto) obj;
   return this.accountId==other.accountId;
 }

 @Override
 public int hashCode() {
    return accountId.hashCode();
 }
}