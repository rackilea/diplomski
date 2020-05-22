public static ZonedDateTime convertirAFecha(String fecha) {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  LocalDate date = LocalDate.parse(fecha, formatter);

  ZonedDateTime resultado = date.atStartOfDay(ZoneId.systemDefault());
  return resultado;
}