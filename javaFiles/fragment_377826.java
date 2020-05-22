String filepath = "myfile.txt";
BufferedImage image = null;
try (InputStream is = new FileInputStream(new File(filepath));
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

    String number = br.readLine();
    String title = br.readLine();
    String text = br.readLine();

    System.out.println(number);
    System.out.println(title);
    System.out.println(text);

    ImageInputStream iis = ImageIO.createImageInputStream(is);
    image = ImageIO.read(iis);
    ImageIO.write(image, "png", new File("test.png"));
} catch (Exception exp) {
    exp.printStackTrace();
}