public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        // key that indicates the program to stop
        String stopKey = "stop";
        System.out.println("Enter a string");
        while (!(a = sc.nextLine()).equals(stopKey)) { // when input is equal to key, it stops
            // nothing changed here ...
            int l = a.length();
            int i;
            char b;
            for (i = 0; i < l; i++) {
                b = a.charAt(i);
                if (b == 'a' || b == 'A')
                    System.out.print("01");
                if (b == 'b' || b == 'B')
                    System.out.print("02");
                if (b == 'c' || b == 'C')
                    System.out.print("03");
                if (b == 'd' || b == 'D')
                    System.out.print("04");
                if (b == 'e' || b == 'E')
                    System.out.print("05");
                if (b == 'f' || b == 'F')
                    System.out.print("06");
                if (b == 'g' || b == 'G')
                    System.out.print("07");
                if (b == 'h' || b == 'H')
                    System.out.print("08");
                if (b == 'i' || b == 'I')
                    System.out.print("09");
                if (b == 'j' || b == 'J')
                    System.out.print("10");
                if (b == 'k' || b == 'K')
                    System.out.print("11");
                if (b == 'l' || b == 'L')
                    System.out.print("12");
                if (b == 'm' || b == 'M')
                    System.out.print("13");
                if (b == 'n' || b == 'N')
                    System.out.print("14");
                if (b == 'o' || b == 'O')
                    System.out.print("15");
                if (b == 'p' || b == 'P')
                    System.out.print("16");
                if (b == 'q' || b == 'Q')
                    System.out.print("17");
                if (b == 'r' || b == 'R')
                    System.out.print("18");
                if (b == 's' || b == 'S')
                    System.out.print("19");
                if (b == 't' || b == 'T')
                    System.out.print("20");
                if (b == 'u' || b == 'U')
                    System.out.print("21");
                if (b == 'v' || b == 'V')
                    System.out.print("22");
                if (b == 'w' || b == 'W')
                    System.out.print("23");
                if (b == 'x' || b == 'X')
                    System.out.print("24");
                if (b == 'y' || b == 'Y')
                    System.out.print("25");
                if (b == 'z' || b == 'Z')
                    System.out.print("26");
                if (b == ' ')
                    System.out.print("27");
            }
            // ask for a new input
            System.out.println("\nEnter a string");
        }
        // at this point user have enter the stop key 
        System.out.println("Stoped. Bye!");
        // close the Scanner
        sc.close();
    }