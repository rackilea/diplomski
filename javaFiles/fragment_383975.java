package example;

import java.io.StringReader;
import java.util.Date;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCSVException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

public class VariableColumns {

    private static final String INPUT = "name,birthDate,city\n"
        + "John,New York\n" 
        + "Sally,22/03/1974,London\n" 
        + "Jim,Sydney";

    // cell processors
    private static final CellProcessor[] NORMAL_PROCESSORS = 
    new CellProcessor[] {null, new ParseDate("dd/MM/yyyy"), null };
    private static final CellProcessor[] NO_BIRTHDATE_PROCESSORS = 
    new CellProcessor[] {null, null };

    // name mappings
    private static final String[] NORMAL_HEADER = 
    new String[] { "name", "birthDate", "city" };
    private static final String[] NO_BIRTHDATE_HEADER = 
    new String[] { "name", "city" };

    public static void main(String[] args) {

        // using bean reader and list reader together (to read the same file)
        final ICsvBeanReader beanReader = new CsvBeanReader(new StringReader(
                INPUT), CsvPreference.STANDARD_PREFERENCE);
        final ICsvListReader listReader = new CsvListReader(new StringReader(
                INPUT), CsvPreference.STANDARD_PREFERENCE);

        try {
            // skip over header
            beanReader.getCSVHeader(true);
            listReader.getCSVHeader(true);

            while (listReader.read() != null) {

                final String[] nameMapping;
                final CellProcessor[] processors;

                if (listReader.length() == NORMAL_HEADER.length) {
                    // all columns present - use normal header/processors
                    nameMapping = NORMAL_HEADER;
                    processors = NORMAL_PROCESSORS;

                } else if (listReader.length() == NO_BIRTHDATE_HEADER.length) {
                    // one less column - birth date must be missing
                    nameMapping = NO_BIRTHDATE_HEADER;
                    processors = NO_BIRTHDATE_PROCESSORS;

                } else {
                    throw new SuperCSVException(
                            "unexpected number of columns: "
                                    + listReader.length());
                }

                // can now use CsvBeanReader safely 
                // (we know how many columns there are)
                Person person = beanReader.read(Person.class, nameMapping,
                        processors);

                System.out.println(String.format(
                        "Person: name=%s, birthDate=%s, city=%s",
                        person.getName(), person.getBirthDate(),
                        person.getCity()));

            }
        } catch (Exception e) {
            // handle exceptions here
            e.printStackTrace();
        } finally {
            // close readers here
        }
    }

    public static class Person {

        private String name;
        private Date birthDate;
        private String city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

}