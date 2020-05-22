Class < ? > [ ] getDeclaredAnnotations ( Method method )
{
       Annotation [ ] as = method . getDeclaredAnnotations ( ) ;
       Class < ? > [ ] bs = new Class < ? > [ as . length ] ;
       for ( int i = 0 ; i < as . length ; i ++ )
       {
              Annotation a = as [ i ] ;
              b [ i ] = a ;
       }
       return bs ;
}