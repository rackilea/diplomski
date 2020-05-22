class ContainsAnonymousInnerClass$1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        s.toString(); // Notice this - it is not prefixed by this$0 as one would expect!
    }

    final ContainsAnonymousInnerClass this$0;
    ContainsAnonymousInnerClass$1() {
        this$0 = ContainsAnonymousInnerClass.this; // reference to the outer class
        super();
    }
}