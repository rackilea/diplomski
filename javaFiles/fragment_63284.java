final int AmountNumbers = 1000;
final int MaxSize = 500000;

// create Random Numbers
Random rnd = new Random();
ArrayList<Integer> randomNumbers = new ArrayList<>();
for(int i = 0; i < AmountNumbers; i++)
    randomNumbers.add(rnd.nextInt(MaxSize));

// create picture
int width = AmountNumbers, height = 200;    
BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
Graphics2D ig2 = bi.createGraphics();
ig2.setPaint(Color.red);

// draw lines for every number
for(int i = 0; i < AmountNumbers; i++){
    int rndNumber = randomNumbers.get(i);
    ig2.drawLine( i, rndNumber * height / MaxSize, i,  height); 
}

// save as png
ImageIO.write(bi, "PNG", new File("chart.PNG"));