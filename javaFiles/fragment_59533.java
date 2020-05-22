try (FileInputStream fileStream = new FileInputStream(new File(filePath))) {
    data = new byte[(int)file.length()];
    int total = 0;
    int count;
    while ((count = fileStream.read(data, total, data.length-total)) > 0) {
        total += count;
    }
    for (byte X : data) {
        System.out.print((char)X);
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}catch (IOException e) {
    e.printStackTrace();
}