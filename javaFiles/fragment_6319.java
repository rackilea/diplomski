class MutableBoolean { boolean b; }
MutableBoolean inTail = new MutableBoolean();

IntStream.of(0, 1, 2, 3, 0, 1, 2, 3, 4)
         .filter(i -> inTail.b || i >= 3 && (inTail.b = true))
         .forEach(System.out::println);