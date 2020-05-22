public class SO57387803DrawShapesInPDF
{

    private static class MyImagePanel extends JPanel
    {

        final BufferedImage image;
        //final float scale = .38f;
        final int DPI = 200;
        final float scale = 72f / DPI;

        AffineTransform atg;
        Point start = new Point();
        Point end = new Point();
        boolean isNewLine = true;
        static ArrayList<Line2D> lines = new ArrayList<>();
        static PDDocument document;

        public MyImagePanel() throws IOException
        {
            document = PDDocument.load(new File("XXXX.pdf"));
            PDFRenderer renderer = new PDFRenderer(document);
            image = renderer.renderImageWithDPI(0, DPI, ImageType.RGB);

            addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseReleased(MouseEvent e)
                {
                    if (end != start)
                    {
                        Line2D line = new Line2D.Float(start.x, start.y, end.x, end.y);
                        lines.add(line);
                        Point2D p = calcCoordinates(e);
                        start = new Point();
                        start.x = (int) p.getX();
                        start.y = (int) p.getY();

                        repaint();
                    }

                }
            });
            addMouseMotionListener(new MouseMotionAdapter()
            {
                @Override
                public void mouseMoved(MouseEvent e)
                {
                    Point2D p = calcCoordinates(e);
                    end = new Point();

                    end.x = (int) p.getX();
                    end.y = (int) p.getY();
                    repaint();
                }
            });
        }

        private Point2D calcCoordinates(MouseEvent e)
        {
            Point p = new Point(e.getX(), e.getY());
            try
            {
                return atg.inverseTransform(p, null);
            }
            catch (NoninvertibleTransformException ex)
            {
                return p;
            }
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            Graphics2D g2D = (Graphics2D) g.create();

            double affineX = (getWidth() - scale * image.getWidth()) / 2;
            double affineY = (getHeight() - scale * image.getHeight()) / 2;

            AffineTransform at = new AffineTransform();
            at.translate(affineX, affineY);
            at.scale(scale, scale);

            AffineTransform atf = g2D.getTransform();
            atf.concatenate(at);
            atg = (AffineTransform) at.clone();

            g2D.setTransform(atf);

            g2D.drawImage(image, 0, 0, this);
            try
            {
                g2D.drawLine(start.x, start.y, end.x, end.y);
            }
            catch (NullPointerException e)
            {

            }

            for (Line2D l : lines)
            {
                g2D.draw(l);
            }

            g2D.dispose();
        }

        public void save()
        {

            try
            {
                PDPage page = document.getPage(0);

                PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);

                for (Line2D l : lines)
                {
                    Point2D p1 = new Point2D.Double(l.getX1(), l.getY1());
                    Point2D p2 = new Point2D.Double(l.getX2(), l.getY2());
                    p1 = atg.transform(p1, null);
                    p2 = atg.transform(p2, null);
                    //contentStream.moveTo((float) l.getX1(), (float) l.getY1());
                    //contentStream.lineTo((float) l.getX2(), (float) l.getY2());
                    contentStream.moveTo((float) p1.getX(), page.getMediaBox().getHeight() - (float) p1.getY());
                    contentStream.lineTo((float) p2.getX(), page.getMediaBox().getHeight() - (float) p2.getY());
                    contentStream.stroke();
                }

                contentStream.close();

                document.save(new File("saved.pdf"));
                document.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(SO57387803DrawShapesInPDF.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public Dimension getPreferredSize()
        {
            int width = (int) (scale * image.getWidth());
            int height = (int) (scale * image.getHeight());
            return new Dimension(width, height);
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("PDF");
        frame.setSize(1500, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // MyImagePanel imagePanel = null;
        MyImagePanel imagePanel;
        try
        {
            imagePanel = new MyImagePanel();
        }
        catch (IOException ex)
        {
            Logger.getLogger(SO57387803DrawShapesInPDF.class
                    .getName()).log(Level.SEVERE, null, ex);
            return; // or there would be an uninitialized variable
        }

        JButton btn = new JButton("Save");

        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                imagePanel.save();
                //MyImagePanel.save();
            }
        });

        btn.setBounds(10, 0, 70, 30);

        frame.add(btn);
        JPanel pnl = new JPanel();
        pnl.add(imagePanel);
        pnl.setBounds(0, 100, 1500, 1200);
        frame.add(pnl);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

}