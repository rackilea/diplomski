import java.text.ParseException;

public class Person {
    private int pageNum;
    private String name;
    private String email;
    private String cell;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Person() {
        this(0, "", "", "");
    }

    public Person(int pageNum, String name, String email, String cell) {
        this.pageNum = pageNum;
        this.name = name;
        this.email = email;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return String.format("Person [pageNum=%s, name=%s, email=%s, cell=%s]", pageNum, name, email, cell);
    }

    public static void main(String[] args) {
        String data = "1,John Doe,john@doe.org,555-555-5555";

        try {
            Person johnDoe = Person.parse(data, ",");
            System.out.println(johnDoe);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Person parse(String input, String delimiter) throws ParseException {
        Person result = new Person();
        String[] tokens = input.split(delimiter);

        if (tokens.length != 4) {
            throw new ParseException(String.format("Malformed Person input: %s%n", input), 0);
        }

        result.setPageNum(Integer.parseInt(tokens[0], 10));
        result.setName(tokens[1]);
        result.setEmail(tokens[2]);
        result.setCell(tokens[3]);

        return result;
    }
}