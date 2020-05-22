jComboBox1 = new JComboBox();
        Iterator it = cashCheckout.products.keySet().iterator();
        while(it.hasNext())
        {
            jComboBox1.addItem(cashCheckout.products.get(it.next()));
        }