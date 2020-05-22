public static int menu(String texto, List<?> opciones) {
    for (int i = 0; i < opciones.size(); i++) {
        System.out.println((i + 1) + ") " + opciones.get(i).toString());
    }

    return solicitarNumero(texto + " [1-"
            + opciones.size() + "]", true, 1, opciones.size());
}