class Implementation<A> implements SomeInteface<A, Holder<A>>{    
          public Holder<A> doSomething(A a){  
              //do stuff  
              return new Holder<A>(a);  
          }     

   }