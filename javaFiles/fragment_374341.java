Random r = new Random(23);
        r.ints(10,1,100).forEach(a->System.out.print(a + " " ));
        System.out.println();

        r = new Random(23);

        r.ints(10,1,100).skip(5).forEach(a->System.out.print(a + " "));