byte[] output = new byte[input.length];
entry = zipIn.getNextEntry();
zipIn.read(output);

System.out.println("Are they equal? " + Arrays.equals(input, output));

// and if we want the size
zipIn.getNextEntry(); // or zipIn.read();
System.out.println("and the size is " + entry.getSize());