model.addColumn("Col1");
    model.addColumn("Col2");

    model.addRow(new Object[]{"1", "v2"});
    model.addRow(new Object[]{"2", "v2"});

    List<String> numdata = new ArrayList<String>();
    for (int count = 0; count < model.getRowCount(); count++){
          numdata.add(model.getValueAt(count, 0).toString());
    }

    System.out.println(numdata);