/**
 * Allows chaining with any class, even one you didn't write and don't have 
 * access to the source code for, so long as that class is fluent.
 * @author Gregory G. Bishop ggb667@gmail.com (C) 11/5/2013 all rights reserved. 
 */
public final class Chain {
   public static <K> _<K> a(K value) {//Note that this is static
      return new _<K>(value);//So the IDE names aren't nasty
   }
}