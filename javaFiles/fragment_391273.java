byte[] canvasData = ((DataBufferByte)canvas.getRaster().getDataBuffer()).getData();
byte[] idealData  = ((DataBufferByte)ideal .getRaster().getDataBuffer()).getData();

int error = 0;
for (int i = 0; i < canvasData.length; i++) {
    error += Math.abs((canvasData[i] & 0xFF) - (idealData[i] & 0xFF));
}