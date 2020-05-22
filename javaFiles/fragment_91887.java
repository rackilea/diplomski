/**
 * interface for objects who allow adding some other objects
 */
interface Addable<T> {
   /** returns the sum of this object and another object. */
   T plus(T summand);
}