@Override
public void start(Stage primaryStage) {
    Button button = new Button("print");
    StackPane root = new StackPane(button);
    button.setOnAction(evt -> {
        try {
            WritableImage nodeshot = root.snapshot(new SnapshotParameters(), null);

            // store image in-memory
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", output);
            output.close();

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            PDImageXObject pdimage;
            PDPageContentStream content;

            pdimage = PDImageXObject.createFromByteArray(doc, output.toByteArray(), "png");
            content = new PDPageContentStream(doc, page);

            // fit image to media box of page
            PDRectangle box = page.getMediaBox();
            double factor = Math.min(box.getWidth() / nodeshot.getWidth(), box.getHeight() / nodeshot.getHeight());

            float height = (float) (nodeshot.getHeight() * factor);

            // beware of inverted y axis here
            content.drawImage(pdimage, 0, box.getHeight() - height, (float) (nodeshot.getWidth() * factor), height);

            content.close();
            doc.addPage(page);

            File outputFile = new File("C:/Users/Andre Kelvin/Desktop/PDFNode.pdf");

            doc.save(outputFile);
            doc.close();

            getHostServices().showDocument(outputFile.toURI().toString());
        } catch (Exception e) {
        }
    });

    Scene scene = new Scene(root, 300, 300);

    primaryStage.setScene(scene);
    primaryStage.show();
}