try (ServletOutputStream stream = response.getOutputStream()) {
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocumentFromString(html);
    renderer.layout();
    renderer.createPDF(stream);
    renderer.finishPDF();
} catch (IOException | DocumentException ex) {
    // Error handling
}