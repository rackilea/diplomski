// OUTPUT
            while (sf >= magcap) {
                sf -= magcap;
                mn++;
            }
            ms(2);
            System.out.println(mn + " mags and " + sf + " shots fired");
            nl(2);
            for (int i = 0; i < mn; i++) {
                from = magcap * magcounter - magcap;
                to = magcap * magcounter;
                System.out.print("Mag " + magcounter + ": ");
                for (int j = from; j < to - 1; j++) {
                    System.out.print(shots[j] + ", ");
                }
                System.out.print(shots[to - 1] + ".");
                magcounter++;
                nl(1);
            }
            // PRINT THE REST
            if (sf >= 1) {
                from = magcap * magcounter - magcap;
                to = magcap * magcounter;
                if (sf == 1) {
                    System.out.print("Mag " + magcounter + ": ");
                    System.out.print(shots[from] + ".");
                } else {
                    System.out.print("Mag " + magcounter + ": ");
                    for (int i = 0; i < sf - 1; i++) {
                        System.out.print(shots[from + i] + ", ");
                    }
                    from += sf -1;
                    System.out.print(shots[from] + ".");
                }
            }