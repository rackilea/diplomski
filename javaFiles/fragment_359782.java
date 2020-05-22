Example example = new Example();
example.setValues(10, 5);
System.out.println(example.getValues()); // java.awt.Dimension[width=5,height=10]

Dimension dimension = example.getValues();
dimension.height = -1;
dimension.width = -1;
System.out.println(example.getValues()); // java.awt.Dimension[width=-1,height=-1]