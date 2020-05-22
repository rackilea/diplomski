interface FooService  {
  Bar doThis( String param );
  String doThat( Bar param );
}

class FooServiceImpl implements FooService {
  ...
}