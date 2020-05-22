@Override // always always always use that annotation when overriding!
public boolean equals(Object obj){
  .. this == obj test
  if (obj == null || !(obj instanceof DiscountProduct)){
    return false;
  } 
  if (super.equals(obj)) {
    cast to DiscountProduct and check discountRate