dis.close();

        DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("c:\\out.pdf")));
        out.write(bytes);
        out.close();
        System.out.println("File size: " + read);
        // Ensure all the bytes have been read in
        if (read < bytes.length) {
            System.out.println("Could not completely read: "+file.getName());
        }