Observable<String> getPerroDetails(String perro)
{
  return Observable
           .just( perro + " reloaded" )
           .delay(1000, TimeUnit.MILLISECONDS));
}