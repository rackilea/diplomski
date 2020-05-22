public static enum Tags {
   TAG1, TAG2, TAG3
}

public class Stuff {
   ...
   switch (Tags.valueOf(str)) {
   case TAG1: handleTag1(); break;
   case TAG2: handleTag2(); break;
   case TAG3: handleTag3(); break;
   }
}