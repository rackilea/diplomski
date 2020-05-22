JPanel top = new JPanel();
top.setLayout(new MigLayout("","[][][]")); // Use column constraints here
...
top.add(dateTime, "span 3, wrap"); // span 3 cells and then wrap
top.add(new JButton("Inventory"));
top.add(new JButton("Transaction"));
top.add(new JButton("Add Item"));