public class FirstVideo extends FirstCanvas {
   ...
}

public class SecondVideo extends SecondCanvas {
   ...
}

...
video = (something ? new FirstVideo() : new SecondVideo());