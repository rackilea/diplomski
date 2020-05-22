Shape[] myshape = new Shape[13];

// populate array

// writing array to disk
FileOutputStream f_out = new FileOutputStream("C:\myarray.data");
ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
obj_out.writeObject(array);

// reading array from disk
FileInputStream f_in = new FileInputStream("C:\myarray.data");
ObjectInputStream obj_in = new ObjectInputStream (f_in);
Shape[] tmp_array = (Shape[])obj_in.readObject();