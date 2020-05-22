boolean numberConsulted = true;

if ((filas_distritos != null) && (!filas_distritos.isEmpty()) || (filas_distritos.size() != 0)) {
    // .... code ...
} else {
    numberConsulted = false;
}


if (numberConsulted) {
    distrito.put("mensaje", "El n&uacute;mero consultado (" + numero + ") ya pertenece a un Distrito de Tarificaci&oacute;n.");
} else {
    distrito.put("mensaje", "El n&uacute;mero consultado (" + numero + ") no pertenece a un Distrito de Tarificaci&oacute;n.");
}