Dropit()
{
    setLayout(null);
    tf = new JTextField();
    tf.setBounds(50, 50, 100, 100);
    add(tf);
    map.put("mon", mon);
    map.put("tue", tue);
    lis = new JComboBox<String>(days);
    lis.setSelectedItem("sat");
    lis.addActionListener(this);
    lis.setBounds(100,100,100,100);
    add(lis);


    pop = new JComboBox<String>();
    pop.setBounds(200,100 , 100, 100);
    pop.setVisible(false);
    add(pop);
    setVisible(true);
    setSize(500,500);
}

public void actionPerformed(ActionEvent e)
{
    lis = (JComboBox<String>) e.getSource();
    String name = (String) lis.getSelectedItem();
    tf.setText(name);

    if (map.containsKey(name))
    {
        pop.removeAllItems();
        for (String s: map.get(name))
            pop.addItem(s);
        pop.setVisible(true);
    } else 
        pop.setVisible(false);
}