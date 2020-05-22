/** 
 * An instance method cannot override the static method from Chain, 
 * which is why this class exists (i.e. to suppress IDE warnings, 
 * and provide fluent usage). 
 *
 * @author Gregory G. Bishop ggb667@gmail.com (C) 11/5/2013 all rights reserved.
 */
final class _<T> {
   public T a;//So we may get a return value from the final link in the chain.
   protected _(T t) { this.a = t }//Required by Chain above
   public <K> _<K> a(K value) {
      return new _<K>(value);
   }
}