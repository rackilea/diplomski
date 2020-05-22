class Test {
    private List<String> myList;
    public void setList(List<String> list) {
        myList = list;
    }
    public void showLengths() {
        for (String s : myList) {
             System.out.println(s.length());
        }
    }
}

...

List<Integer> doesNotWork = new ArrayList<Integer>();
doesNotWork.add(1);
doesNotWork.add(2);
doesNotWork.add(3);
Test tst = new Test();
tst.setList(doesNotWork); // <<== Will not compile
Method setList = Test.class.getMethod("setList", List.class);
setList.invoke(tst, doesNotWork); // <<== This will work;
tst.showLengths(); // <<== However, this will produce a class cast exception