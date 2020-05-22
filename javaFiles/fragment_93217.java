[...]
    fos = new FileOutputStream("03032015.dbd");
                out = new ObjectOutputStream(fos);

                table.setModel(new DefaultTableModel()); // detach model from table while serializing to prevent it from failing
                out.writeObject(model);
                table.setModel(model);
[...]