@Override
public void notifyElementPut(final Ehcache cache, final Element element) throws CacheException {

   Map elementValue = (Map) element.getObjectValue();
   if(elementValue.size() <= 1){
       remove(element);
   }
}