if (!file.exists()) {
    file.mkdir();
    file.createNewFile();
}

FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);