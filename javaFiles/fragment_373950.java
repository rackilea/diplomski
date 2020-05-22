ArrayList list = new ArrayList();
list.add(0, 1);
list.add(1, 4);
list.add(2, 5);
list.add(3, 10);
int a = 0;
for (Object str : list) {
    a = Integer.parseInt(String.valueOf(str));
    System.out.println(a);

}