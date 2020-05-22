// With String
serialize("Hello World!", out);

// With int
serialize(2547, out);

// with byte-array
serialize(new byte[]{1,3,5,6}, out);

// with userdefined object
serialize(new MyObject(), out);