public Test() {

    super("t");
    setDefaultCloseOperation(EXIT_ON_CLOSE);     
    JPanel test = test();
    JPanel testing = testing();
    JPanel testing123 = testing123();
    p.add(test);
    p.add(testing);
    add(p, BorderLayout.CENTER);             <---
    add(testing123, BorderLayout.PAGE_END);  <---
    pack();
    setVisible(true);
}