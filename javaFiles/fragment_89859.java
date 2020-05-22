ArrayList<Integer> myList = new ArrayList<Integer>();
        Scanner val = new Scanner(System.in); //can't figure out how to get user input from editText
        int x = 0;
        for (int i = 0; i < 3; i++) {
            x = val.nextInt();
            myList.add(x);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            myList.sort(null);
        }

        for (int i = myList.size() - 1; i >= 0; i--) {
            answer += myList.get(i).toString();
        }