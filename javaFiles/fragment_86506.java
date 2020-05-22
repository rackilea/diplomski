public void inputCity() {
        Scanner in = new Scanner(System.in);
        while (!in.next().equals("###")) {
            city.add(in.next());
        }
       in.close()
    }