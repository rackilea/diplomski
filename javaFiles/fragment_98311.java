do {
        cs.ShowMenu();
        ch = (char) System.in.read();
        switch (ch) {
        case '1': {
            System.out.println("228");
            break;
        }
        case '2': {
            System.out.println("556");
            break;
        }
        }
        System.in.read();
    } while (ch != '0');