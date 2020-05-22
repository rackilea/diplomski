Scanner scan = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();
        String s;
        while (true) {
            s = scan.nextLine();
            if (s.equals("")) {
                break;
            }
            lines.add(s);
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }