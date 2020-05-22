// unmarshal Project
for(Layer layer : project.getLayer()) {
    if (layer.getIdLayer().equals("2")) {
        layer.setLayerName("b");
    }
}
// marshal Project back to XML