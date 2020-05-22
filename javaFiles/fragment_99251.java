final ArrayList<Integer> list = new ArrayList<>();
list.add(5);

new Runnable() { public void run() { list.add(6); } }.run();

System.out.println(list);   // [5, 6] (would be [5] if had been deep-copied)