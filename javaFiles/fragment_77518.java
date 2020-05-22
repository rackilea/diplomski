interface Lambda<R> {
    R exec();
 }
 interface Lambda<R,A> {
    R exec( A a );
 }