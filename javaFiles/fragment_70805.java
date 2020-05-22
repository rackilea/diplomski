public int transferTo(Account another, int amount) throws Exception{  
 if(another==null){
  throw new NullPointerException("To Account Cannot be Null"); 
 }

 if(this.getBal()> amount){  
  this.setBal(this.getBal() - amount);
  another.setBal(another.getBal() + amount);
 }else{
   throw new InsufficientFundsException("Insufficient funds! for " + this.id + ": "  + this.name );
 }
  return this.getBal(); // return total balance of account;
}