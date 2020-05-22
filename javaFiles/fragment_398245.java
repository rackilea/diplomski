/**
    * Regular expression modifier values.  Instead of being passed as
    * arguments, they can also be passed as inline modifiers.
    * For example, the following statements have the same effect.
    * <pre>
    * RegExp r1 = RegExp.compile("abc", Pattern.I|Pattern.M);
    * RegExp r2 = RegExp.compile("(?im)abc", 0);
    * </pre>
    *
    * The flags are duplicated so that the familiar Perl match flag
    * names are available.
    */