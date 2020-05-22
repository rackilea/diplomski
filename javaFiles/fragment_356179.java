for(int i=0; i<files.length-1; i++) {
    for(int j=i+1; j<files.length; j++) {
        byte[] f1 = Files.readAllBytes(files[i]);
        byte[] f2 = Files.readAllBytes(files[j]);

        if (Arrays.equals(f1, f2))
            System.out.println("file #" + i + " and file #" + j + " are identical.";
        else
            System.out.println("file #" + i + " and file #" + j + " are different.";
    }
}