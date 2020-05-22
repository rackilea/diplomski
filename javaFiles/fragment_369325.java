public static void main(String[] args) {

            List<List<Integer>> listOfList = new ArrayList<List<Integer>>();

            Random rand = new Random(System.currentTimeMillis());

            for (int i = 0; i < 5; i++) {
                List<Integer> list = new ArrayList<Integer>();
                for (int j = 0; j < 5; j++) {
                    list.add(rand.nextInt(1000));
                }
                listOfList.add(list);
            }

            while (listOfList.size() > 1) {

                Iterator<List<Integer>> itr = listOfList.iterator();
                List<Integer> first = itr.next();

                while (itr.hasNext()) {
                    List<Integer> temp = itr.next();
                    first.addAll(temp);
                    itr.remove();
                    Collections.sort(first);
                }
            }

            List<Integer> first = listOfList.get(0);
            for (Integer integer : first) {
                System.out.print(integer + ", ");
            }
        }