ArrayList arr = new ArrayList();
        for (int i = 0; i < shipmain.files.length; i++) {
            arr.add(shipmain.files[i]);
            arr.add(shipmain.fabricName[i]);
            arr.add(shipmain.color[i]);

            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.addRow(arr.toArray());
            jTable1.setModel(model);
            arr.remove(shipmain.files[i]);
            arr.remove(shipmain.fabricName[i]);
            arr.remove(shipmain.color[i]);
        }