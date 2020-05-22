public class Validator {
    public static void main(String[] args) {
        UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
        if (urlValidator.isValid("http://localhost/page.htm")) {
            System.out.println("Valid URL");
        }
        else {
            System.out.println("Invalid URL");
        }

    }

}