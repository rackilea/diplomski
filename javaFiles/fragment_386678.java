String[] examples = new String[] {"test", "a", "long one", "", "one was blank (this is longest)"};
    Arrays.sort(examples, new Comparator<String>() {

        @Override
        public int compare(String arg0, String arg1) {
            if(arg0.length() < arg1.length())
                return -1;
            if(arg0.length() > arg1.length())
                return 1;
            return 0;
        }

    });
    System.out.println(Arrays.toString(examples));