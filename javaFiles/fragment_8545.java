class Currency extends Magnitude {
double amount;

public Currency(double amt) {
    this.amount = amt;
}

@Override
public boolean lessThan(Magnitude m) {
  Currency other_currency = (Currency) m;

  if (this.amount < other_currency.amount) {
      return true;
  }
  else {
     return false
  }
}

public void print() {
   System.out.println(amount);
}
}