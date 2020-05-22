public class PDFBox3359PanelTestEnhanced
{

    private static JPanel getTestPanel()
    {
        final PDDocument doc;
        try
        {
            doc = PDDocument.load(new File("XXXXX.pdf"));   

        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        final PDFRenderer renderer = new PDFRenderer(doc);
        JPanel panel = new JPanel()
        {
            int i;

            @Override
            protected void paintComponent(Graphics g)
            {
                try
                {
                    g.setColor(Color.red);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    PDPage page = doc.getPage(0);
                    PDRectangle cropBox = page.getCropBox();
                    boolean rot = false;
                    if (page.getRotation() == 90 || page.getRotation() == 270)
                    {
                        rot = true;
                    }

                    // https://stackoverflow.com/questions/1106339/resize-image-to-fit-in-bounding-box
                    float imgWidth = rot ? cropBox.getHeight() : cropBox.getWidth();
                    float imgHeight = rot ? cropBox.getWidth() : cropBox.getHeight();
                    float xf = getWidth() / imgWidth;
                    float yf = getHeight() / imgHeight;
                    float scale = Math.min(xf, yf);
                    if (yf < xf)
                    {
                        g.translate((int) ((getWidth() - imgWidth * yf) / 2), 0);
                    }
                    else
                    {
                        g.translate(0, (int) ((getHeight() - imgHeight * xf) / 2));
                    }
                    renderer.renderPageToGraphics(0, (Graphics2D) g, scale);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
        return panel;
    }

    public static void main(String[] args) throws Exception
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.add(getTestPanel());
                frame.pack();
                frame.setSize(600, 400);
                Dimension paneSize = frame.getSize();
                Dimension screenSize = frame.getToolkit().getScreenSize();
                frame.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                frame.setTitle("Test");
                frame.setVisible(true);
            }
        });
    }
}