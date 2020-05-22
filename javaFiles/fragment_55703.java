File output = new File("C://SnippingTool+/" +  date.getDay() + ".jpg");
File dir = output.getParentFile();
if (dir.exists() || dir.mkdirs()) {
    try {
        ImageIO.write(shot, "JPG", output);
    } catch (IOException e) {
        e.printStackTrace();
    }    
} else {
    System.out.println("Bad Path - " + dir);
}