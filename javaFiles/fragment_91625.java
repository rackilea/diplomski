Document document = new Document();
File arquivo = new File("C:\\Users\\Mateus\\Desktop\\testezãozarãozão.pdf");
PdfWriter.getInstance(document, new FileOutputStream(arquivo));
document.open();

LinkedHashMap<Produto, LinkedHashMap<String, List<PrePedidoItem>>> produtos = createStructuredHashMap();

for (Produto produto : produtos.keySet()) {
    PdfPTable table = new PdfPTable(5);
    PdfPCell cellProduto = new PdfPCell();
    Phrase phraseProduto = new Phrase(String.valueOf(produto));
    phraseProduto.setFont(new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD|Font.UNDERLINE, new BaseColor(50, 65, 200)));
    cellProduto.addElement(phraseProduto);
    cellProduto.setColspan(5);
    cellProduto.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
    cellProduto.setBorder(Rectangle.NO_BORDER);
    cellProduto.setPaddingBottom(10);
    cellProduto.setPaddingTop(20);
    table.addCell(cellProduto);
    LinkedHashMap<String, List<PrePedidoItem>> mapas = produtos.get(produto);
    int mapasAdicionados = 0;
    for (String mapa : mapas.keySet()) {
        PdfPCell cellMapa = new PdfPCell();
        Phrase phraseMapa = new Phrase(mapa);
        phraseMapa.setFont(new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, new BaseColor(215, 100, 0)));
        cellMapa.addElement(phraseMapa);
        List<PrePedidoItem> itensDoMapa = mapas.get(mapa);
        for (PrePedidoItem item : itensDoMapa) {
            DecimalFormat df = new DecimalFormat("###,##0.00");
            Phrase phraseItem = new Phrase(df.format(item.getLargura()) + " x " + df.format(item.getComprimento()));
            phraseItem.setFont(new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK));
            cellMapa.addElement(phraseItem);
        }
        cellMapa.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellMapa);
        mapasAdicionados ++;
        if(mapasAdicionados == 5) {
            mapasAdicionados = 0;
        }
    }
    PdfPCell celulaPreenchimentoMapas = new PdfPCell();
    celulaPreenchimentoMapas.setColspan(5 - mapasAdicionados);
    celulaPreenchimentoMapas.setBorder(Rectangle.NO_BORDER);
    table.addCell(celulaPreenchimentoMapas);
    document.add(table);
}

document.close();
Desktop.getDesktop().open(arquivo);