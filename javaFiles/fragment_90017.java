final Integer[] data = new Integer[] { null, null, 3, 4, null };
    Arrays.sort(data, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            if(o1 != null && o2!=null){
                return o1.compareTo(o2);
            }else if(o2 != null){
                return o2;
            }else{                  
                return Integer.MIN_VALUE; // null values in the end
            }
        }
    });

    System.out.println(Arrays.toString(data));