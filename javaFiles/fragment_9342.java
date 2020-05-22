public void actionPerformed(ActionEvent e)
{
    lis = (JComboBox) e.getSource();
    String name = (String) lis.getSelectedItem();
    tf.setText(name);

    if (map.containsKey(name))
    {
        if (pop != null)
            this.remove(pop);
        pop = new JComboBox(map.get(name));
        pop.setBounds(200,100 , 100, 100);
        add(pop);
    }
}