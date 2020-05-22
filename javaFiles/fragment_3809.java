try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\output.txt"))) {

    for (int i = 0; i < names.length; i++){
        System.out.println(names[i]);
        bw.write(names[i]);
        bw.newLine();
    }
}