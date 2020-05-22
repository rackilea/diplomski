public static void main(String[] args) {

    JFrame f = new JFrame();
    List<Client> cs = new ArrayList();

    cs.add(new Client("Hans", 1));
    cs.add(new Client("Peter", 2));
    JComboBox c = new JComboBox<Client>(cs.toArray(new Client[] {}));

    c.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(((Client) e.getItem()).getAge());
        }

    });

    f.add(c);
    f.pack();
    f.setVisible(true);

}