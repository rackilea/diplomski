Document doc = mxXmlUtils.parseXml(erXmlString);
    mxGraph graph = new mxGraph();
    mxCodec codec = new mxCodec(doc);
    codec.decode(doc.getDocumentElement(), graph.getModel());

    mxGraphComponent graphComponent = new mxGraphComponent(graph);
    BufferedImage image = mxCellRenderer.createBufferedImage(graphComponent.getGraph(), null, 1, Color.WHITE, graphComponent.isAntiAlias(), null, graphComponent.getCanvas());
    mxPngEncodeParam param = mxPngEncodeParam.getDefaultEncodeParam(image);
    param.setCompressedText(new String[] { "mxGraphModel", erXmlString });

    FileOutputStream outputStream = new FileOutputStream(new File(filename));
    mxPngImageEncoder encoder = new mxPngImageEncoder(outputStream, param);

    if (image != null) {
        encoder.encode(image);
        return image;
    }
    outputStream.close();
    return null;
}