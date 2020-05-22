public static void main(String[] args) throws IOException {
            String path = "src/logo.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(label, BorderLayout.WEST);

            String path2 = "src/logo.jpg";
            File file2 = new File(path2);
            BufferedImage image2 = ImageIO.read(file2);

            float[] matrix = new float[400];
            for (int i = 0; i < 400; i++)
                matrix[i] = 1.0f/400.0f;

            BufferedImageOp op = new ConvolveOp( new Kernel(20, 20, matrix), ConvolveOp.EDGE_NO_OP, null );
            image2 = op.filter(image, null);
            JLabel label2 = new JLabel(new ImageIcon(image2));
             f.getContentPane().add(label, BorderLayout.WEST);

             f.pack();
             f.setVisible(true);

        }