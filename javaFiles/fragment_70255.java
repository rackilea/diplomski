public static void main(String[] args) throws ParseException {
  Calendar dataRendimentoLordoCertificatoCalendar = Calendar.getInstance();

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  Date dataRendimentoLordoCertifiacato = sdf.parse(sdf.format(dataRendimentoLordoCertificatoCalendar.getTime()));

  System.out.println(dataRendimentoLordoCertifiacato);
}