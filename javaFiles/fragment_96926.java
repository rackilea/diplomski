class MyScatterPlot
{
    private BufferedImage buf;

    //Constructors, initializations not shown.

    public void saveBufferAsImage(String pathname){
        String fmt = "";
        if(!(pathname == null || pathname.equals(""))){
            fmt = pathname.substring(pathname.lastIndexOf(".")+1);
            File outputfile = new File(pathname);
            try{
                ImageIO.write(buf, fmt, outputfile);        
            }catch(IOException ioe){System.out.println("Unable to save file");}
        }       
    }

    public void drawImage(){
        buf = new BufferedImage (200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buf.createGraphics();   
        g2d.fillRect(10, 10, 150, 150);  //draw your image here (example only)
        g2d.dispose();
    }
}