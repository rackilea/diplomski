int size = list.size();
Random random = new Random();

for (int i = 0; i < size; i++) {    
    int index = random.nextInt(list.size());
    int number1 = list.remove(index);
    System.out.println(number1);
}