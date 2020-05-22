public boolean trueIdTienda(String s) {
    for (int x = 0; x < lista.size(); x++) {
        if (s.equals(ventas.getVenta(x).getIdTienda())){
            return true;
        }
    }
    return false;
}