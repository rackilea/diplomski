private void dibujarImagen(Item i, int x, int y, int alto, int ancho) throws IOException {
    PDPixelMap img = null;

    try {
        img = new PDPixelMap(documento, read(getClass().getResourceAsStream("/com/img/" + i.getId() + ".png")));
    }
    catch (IllegalArgumentException e) {
        img = new PDPixelMap(documento, SwingFXUtils.fromFXImage(Funciones.crearImagenDesdeTexto(i.getNombre()),null));
    }
    finally {
        contenedor.drawXObject(img, x, y, alto, ancho);
    }
}