String input = "hello";
input = input.replaceAll("(\\w)(?!\\1)", "$1 ");
System.out.println(Arrays.toString(input.split(" ")));
input = "helel";
input = input.replaceAll("(\\w)(?!\\1)", "$1 ");
System.out.println(Arrays.toString(input.split(" ")));

[h, e, ll, o]
[h, e, l, e, l]