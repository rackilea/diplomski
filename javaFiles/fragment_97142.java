public static EntityC4 getitemfromnumber(int num)
{
  EntityC4 entity = null;
  if ( num >=0 && num < C4.size ){
    entity = (EntityC4)C4.get(num);
  }
  return entity;
}