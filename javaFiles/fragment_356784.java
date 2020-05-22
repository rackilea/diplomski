String path = "filePath";
    File file = new File (path);
    Scanner scanner = new Scanner(file);
    Long[][] yd = new Long[0][];
    long prev = 0;
    for(scanner.nextLine();scanner.hasNext();){
        long year = scanner.nextLong();
        long curnt = scanner.nextLong();
        long diff = prev==0?prev:curnt-prev;
        prev = curnt;
        yd = Arrays.copyOf(yd, yd.length+1);
        yd[yd.length-1] = new Long[2];
        yd[yd.length-1][0] = year;
        yd[yd.length-1][1] = diff;
    }
    Arrays.sort(yd, new Comparator<Long[]>() {
        @Override
        public int compare(Long[] o1, Long[] o2) {
            Long diffOne = o1[1];
            Long diffTwo = o2[1];
            return diffTwo.compareTo(diffOne);
        }
    });
    System.out.println("Year="+yd[0][0]+"; Difference="+yd[0][1]);