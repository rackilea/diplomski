List<String> list = new ArrayList<String>(number);

for (int i = 0; i < number; i++)
    list.add(Integer.toString(i));

Collections.shuffle(list);

myQueue.addAll(list);