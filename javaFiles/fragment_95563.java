for (Box b1 : likes[1]) {
    if (!b1.add(1)) continue;
    for (Box b2 : likes[2]) {
        if (!b2.add(2)) continue;
        for (Box b3 : likes[3]) {
            if (!b3.add(3)) continue;
            for (Box b4 : likes[4]) {
                if (!b4.add(4)) continue;
                for (Box b5 : likes[5]) {
                    if (!b5.add(5)) continue;
                    for (Box b6 : likes[6]) {
                        if (!b6.add(6)) continue;
                        for (Box b7 : likes[7]) {
                            if (!b7.add(7)) continue;
                            for (Box b8 : likes[8]) {
                                if (!b8.add(8)) continue;
                                for (Box b9 : likes[9]) {
                                    if (!b9.add(9)) continue;
                                    for (Box b10 : likes[10]) {
                                        if (!b10.add(10)) continue;
                                        for (Box b11 : likes[11]) {
                                            if (!b11.add(11)) continue;
                                            System.out.printf("A=%s B=%s C=%s D=%s%n",
                                                A, B, C, D);
                                            b11.remove(11);
                                        }
                                        b10.remove(10);
                                    }
                                    b9.remove(9);
                                }
                                b8.remove(8);
                            }
                            b7.remove(7);
                        }
                        b6.remove(6);
                    }
                    b5.remove(5);
                }
                b4.remove(4);
            }
            b3.remove(3);
        }
        b2.remove(2);
    }
    b1.remove(1);
}