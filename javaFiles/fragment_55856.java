while ((piece = buf.readLine()) != null) {
     String field[] = piece.split(Descriptor.getFieldSeparator());

     if (field.length >= 6) {
                System.out.println("CPF: " + field[0]);
                System.out.println("Name: " + field[1]);
                System.out.println("Course: " + field[2]);
                System.out.println("Age: " + field[3]);
                System.out.println("Phone: " + field[4]);
                System.out.println("Active: " + field[5]);
     }
}