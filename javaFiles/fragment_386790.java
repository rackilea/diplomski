// not allowed - expressions
IntConsumer a = (i) -> 2 + 2;
IntConsumer b = (i) -> true ? 1 : 0;
IntConsumer c = (i) -> (Function.identity().apply(i));
IntConsumer d = (i) -> (System.out.println(i));
IntConsumer e = (i) -> (new Object());

// allowed - expression statements
IntConsumer f = (i) -> Function.identity().apply(i);
IntConsumer g = (i) -> System.out.println(i);
IntConsumer h = (i) -> new Object();