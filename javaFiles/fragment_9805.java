@Component
@Data
public class AgeCalculator {

    private LocalDate fromStringToLocalDate(String localDateString) {

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return LocalDate.parse(localDateString, inputFormat);
    }

    public int calculateAge(String birthDate) {
        if (birthDate != null) {
            return Period.between(fromStringToLocalDate(birthDate), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}