public String getStartDate(String startDate)
{
    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return LocalDate.parse(startDate, inputFormat).format(outputFormat);
}