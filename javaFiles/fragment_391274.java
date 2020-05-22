int[] canvasData = ((DataBufferInt)canvas.getRaster().getDataBuffer()).getData();
int[] idealData  = ((DataBufferInt)ideal .getRaster().getDataBuffer()).getData();

int error = 0;
for (int i = 0; i < canvasData.length; i++) {
    error += Math.abs((canvasData[i]       & 0xFF) - (idealData[i]       & 0xFF));
    error += Math.abs((canvasData[i] >>  8 & 0xFF) - (idealData[i] >>  8 & 0xFF));
    error += Math.abs((canvasData[i] >> 16 & 0xFF) - (idealData[i] >> 16 & 0xFF));
}