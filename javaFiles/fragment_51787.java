float lowerLeftX = 0;
float lowerLeftY = 0;

@Override
public void processPage(PDPage page) throws IOException {
    PDRectangle pageSize = page.getCropBox();

    lowerLeftX = pageSize.getLowerLeftX();
    lowerLeftY = pageSize.getLowerLeftY();

    super.processPage(page);
}