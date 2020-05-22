static Object lock;

...

if (objectYouAreHopingHasBeenCached == null) {
  synchronized (lock) {
    if (objectYouAreHopingHasBeenCached == null) {
       // fetch the object, put in in objectYouAreHopingHasBeenCached
    }
  }
}
return objectYouAreHopingHasBeenCached;