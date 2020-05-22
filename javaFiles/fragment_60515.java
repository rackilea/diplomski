import static j2html.TagCreator.body;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;

public class _50480568 {

    public static void main(String[] args) {
        System.out.println(generateHTML());
    }

    private static String generateHTML() {
        return html(generateBody()).renderFormatted();
    }

    private static ContainerTag generateBody() {
        return body(generetaH1Title(), generateForm());
    }

    private static ContainerTag generateForm() {
        return form().withMethod("post").withAction("/yourServlet").with(generateUserField(), generatePasswordField());
    }

    private static Tag generateUserField() {
        return input().withType("text").withName("user").withId("user");
    }

    private static ContainerTag generetaH1Title() {
        return h1("Hello World - Body!");
    }

    private static Tag generatePasswordField() {
        return input().withType("password").withName("password").withId("password");
    }

}