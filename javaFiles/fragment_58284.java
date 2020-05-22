private void updateRow( Object[] data) {

        String userName = data[0].toString();
        for (int i = 0; i < dm.getRowCount(); i++)
            if (dm.getValueAt(i, 0).equals(userName))
                for (int j = 1; j < data.length; j++)
                    dm.setValueAt(data[j], i, j);
    }