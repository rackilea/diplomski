public class DrawPrintTextLocations extends PDFTextStripper
{
    private BufferedImage image;
    private final String filename;
    static final int SCALE = 4;
    private Graphics2D g2d;
    private final PDDocument document;

    /**
     * Instantiate a new PDFTextStripper object.
     *
     * @param document
     * @param filename
     * @throws IOException If there is an error loading the properties.
     */
    public DrawPrintTextLocations(PDDocument document, String filename) throws IOException
    {
        this.document = document;
        this.filename = filename;
    }

    /**
     * This will print the documents data.
     *
     * @param args The command line arguments.
     *
     * @throws IOException If there is an error parsing the document.
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            usage();
        }
        else
        {
            PDDocument document = null;
            try
            {
                document = PDDocument.load(new File(args[0]));

                DrawPrintTextLocations stripper = new DrawPrintTextLocations(document, args[0]);
                stripper.setSortByPosition(true);

                for (int page = 0; page < document.getNumberOfPages(); ++page)
                {
                    stripper.stripPage(page);
                }
            }
            finally
            {
                if (document != null)
                {
                    document.close();
                }
            }
        }
    }

    private void stripPage(int page) throws IOException
    {
        PDPage pdPage = (PDPage) document.getDocumentCatalog().getAllPages().get(page);
        image = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 72 * SCALE);
        PDRectangle cropBox = pdPage.getCropBox();

        g2d = image.createGraphics();
        g2d.setStroke(new BasicStroke(0.1f));
        g2d.scale(SCALE, SCALE);

        setStartPage(page + 1);
        setEndPage(page + 1);

        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        writeText(document, dummy);

        // beads in green
        g2d.setStroke(new BasicStroke(0.4f));
        List<PDThreadBead> pageArticles = pdPage.getThreadBeads();
        for (PDThreadBead bead : pageArticles)
        {
            PDRectangle r = bead.getRectangle();
            GeneralPath p = transform(r, Matrix.getTranslatingInstance(-cropBox.getLowerLeftX(), cropBox.getLowerLeftY()));
            AffineTransform flip = new AffineTransform();
            flip.translate(0, pdPage.findCropBox().getHeight());
            flip.scale(1, -1);
            Shape s = flip.createTransformedShape(p);
            g2d.setColor(Color.green);
            g2d.draw(s);
        }

        g2d.dispose();

        String imageFilename = filename;
        int pt = imageFilename.lastIndexOf('.');
        imageFilename = imageFilename.substring(0, pt) + "-marked-" + (page + 1) + ".png";
        ImageIO.write(image, "png", new File(imageFilename));
    }

    /**
     * Override the default functionality of PDFTextStripper.
     */
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException
    {
        for (TextPosition text : textPositions)
        {
            System.out.println("String[" + text.getXDirAdj() + ","
                    + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
                    + text.getXScale() + " height=" + text.getHeightDir() + " space="
                    + text.getWidthOfSpace() + " width="
                    + text.getWidthDirAdj() + "]" + text.getCharacter());

            // in red:
            // show rectangles with the "height" (not a real height, but used for text extraction 
            // heuristics, it is 1/2 of the bounding box height and starts at y=0)
            Rectangle2D.Float rect = new Rectangle2D.Float(
                    text.getXDirAdj(),
                    (text.getYDirAdj() - text.getHeightDir()),
                    text.getWidthDirAdj(),
                    text.getHeightDir());
            g2d.setColor(Color.red);
            g2d.draw(rect);
        }
    }

    /**
     * This will print the usage for this document.
     */
    private static void usage()
    {
        System.err.println("Usage: java " + DrawPrintTextLocations.class.getName() + " <input-pdf>");
    }


    /**
     * Transforms the given point by this matrix.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private Point2D.Float transformPoint(Matrix m, float x, float y)
    {
        float[][] values = m.getValues();
        float a = values[0][0];
        float b = values[0][1];
        float c = values[1][0];
        float d = values[1][1];
        float e = values[2][0];
        float f = values[2][2];
        return new Point2D.Float(x * a + y * c + e, x * b + y * d + f);
    }

    /**
     * Returns a path which represents this rectangle having been transformed by the given matrix.
     * Note that the resulting path need not be rectangular.
     */
    private GeneralPath transform(PDRectangle r, Matrix matrix)
    {
        float x1 = r.getLowerLeftX();
        float y1 = r.getLowerLeftY();
        float x2 = r.getUpperRightX();
        float y2 = r.getUpperRightY();

        Point2D.Float p0 = transformPoint(matrix, x1, y1);
        Point2D.Float p1 = transformPoint(matrix, x2, y1);
        Point2D.Float p2 = transformPoint(matrix, x2, y2);
        Point2D.Float p3 = transformPoint(matrix, x1, y2);

        GeneralPath path = new GeneralPath();
        path.moveTo((float) p0.getX(), (float) p0.getY());
        path.lineTo((float) p1.getX(), (float) p1.getY());
        path.lineTo((float) p2.getX(), (float) p2.getY());
        path.lineTo((float) p3.getX(), (float) p3.getY());
        path.closePath();
        return path;
    }

}