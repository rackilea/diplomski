String resultParallel = list.parallelStream().collect(
            StringBuilder::new,
            (builder, elem) -> builder.append(" ").append(elem),
            (left, right) -> left.append(" ").append(right)).toString();

    String result = list.stream().collect(
            StringBuilder::new,
            (builder, elem) -> builder.append(" ").append(elem),
            (left, right) -> left.append(" ").append(right)).toString();


  System.out.println("ResultParallel: ->" + resultParallel + "<-"); // -> 1  2  3  4<-
  System.out.println("Result: ->" + result + "<-"); // -> 1 2 3 4<-