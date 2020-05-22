for(Property prop: properties){
  if(prop.getClass().equals(Shop.class))
       ((Shop) prop).setShopDetails(detail);
  else
       ((Apartment) prop).setAppDetails(detail)
  }
}