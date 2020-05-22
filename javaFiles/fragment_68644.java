public class Foo {

private Company company;

public Foo login(String name) {
    name = name.toLowerCase();
    company = companyDAO.getCompanyByName(name);
    return this;
}