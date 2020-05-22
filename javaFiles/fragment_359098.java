IntStream.concat(IntStream.rangeClosed(2, 15), IntStream.rangeClosed(90, 110))
         .forEach(number -> System.out.printf("%3d = %s%n", number,
            primeFactors(number)
                .mapToObj(d -> {
                    int p = 0;
                    for(long l = number; l%d == 0; l /= d, p++) l++;
                    return p == 1? String.valueOf(d): d + "^" + p;
                })
                .collect(Collectors.joining(" * ")))
         );
}