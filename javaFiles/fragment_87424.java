package com.foobarpkg.maybeanotherpkg;

@Service 
class Foobar implement IFoobar {
  @Autowired
  Foobar (IFoo foo) { // not that interface should be used here instead of concrete class (Foo/Fooz)
  } 
}