BufferedImage bim=null;
  try {
    bim=ImageIO.read(new File("str.gif"));
  }
  catch (Exception ex) { System.err.println("error"); }
  int wc=bim.getWidth(), hc=bim.getHeight();
  BufferedImage b2=new BufferedImage(wc, hc, BufferedImage.TYPE_INT_RGB);

  int[] pix=bim.getRGB(0, 0, wc, hc, null, 0, wc);
  int[][] pix2=new int[wc][hc];
  double ri;
  for(i=0; i<wc; i++)
  for(j=0; j<hc; j++) {
    int rr=(pix[i+j*wc]&0x00ff0000)>>16, rg=(pix[i+j*wc]&0x0000ff00)>>8, rb=pix[i+j*wc]&0x000000ff;
    ri=0.2126*rr+0.7152*rg+0.0722*rb;
    pix2[i][j]=(int)ri;
  }
  double max=0;
  for(i=0; i<wc; i++)
  for(j=0; j<hc; j++) {
  if(i%10==0 && j%10==0) System.out.println(i+" "+j);
    double ki=ft(i, j, 0, 0, hc, wc, pix2, 1);
    if(ki>max) max=ki;
    b2.setRGB(i, j, (int)ki);
  }
  saveImageIO(b2, (time/1000)+"f-1");

  double cc=255./Math.log(1+max);
  System.out.println(max+" "+cc);
  for(i=0; i<wc; i++)
  for(j=0; j<hc; j++) {
    b2.setRGB(i, j, (int) (Math.log(1+(b2.getRGB(i, j)&0x00ffffff))*cc));
  }   

  saveImageIO(b2, (time/1000)+"f-2");