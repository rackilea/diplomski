try (FileWriter fw = new FileWriter("C:\\IntelliJfiles\\write-to-file\\src\\pl\\sca\\file.txt");
     BufferedWriter bw = new BufferedWriter(fw)){
    bw.write("kal");
} catch (Exception e) {
    e.printStackTrace();
}