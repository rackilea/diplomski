JButton myButton = new JButton();
JTextField myTextField = new JTextField();
JFrame myFrame = new JFrame();

ArrayList<Object> a = new ArrayList<>();
a.add("My String");
a.add(23234);
a.add(376754356L);
a.add(345.74678D);
a.add(3.54f);
a.add(true);
a.add('A');
a.add(myButton);
a.add(myTextField);
a.add(myFrame);

for (int i = 0; i < a.size(); i++) {
    System.out.println("Element at index " + i + " contains a " + 
                varType(a.get(i)) + " Object.");
}