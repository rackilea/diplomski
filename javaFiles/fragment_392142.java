public static void main(String[] args) {
        RenderedImage image = JAI.create("fileload", "estacaosp.jpg");

        float scale=(float) 0.5;

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(image);

        pb.add(scale);
        pb.add(scale);
        pb.add(1.0F);
        pb.add(1.0F);

        pb.add(new InterpolationNearest() );// ;InterpolationBilinear());
        image = JAI.create("scale", pb);

        // Create an instance of DisplayJAI.
        DisplayJAI srcdj = new DisplayJAI(image);

        JScrollPane srcScrollPaneImage = new JScrollPane(srcdj);

// Use a label to display the image
        JFrame frame = new JFrame();

        frame.getContentPane().add(srcScrollPaneImage, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }