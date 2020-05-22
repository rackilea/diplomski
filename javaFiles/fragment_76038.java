System.out.println(
    Arrays.deepToString(
        "abc<def>ghi<x><x>".split("(?=<)|(?<=>)")
    )
); // [abc, <def>, ghi, <x>, <x>]


System.out.println(
    Arrays.deepToString(
        "Hello! Oh my!! Good bye!! IT WORKS!!!".split("(?<=!++)")
    )
); // [Hello!,  Oh my!!,  Good bye!!,  IT WORKS!!!]