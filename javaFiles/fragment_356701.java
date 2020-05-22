public class EmailValidation {
    public static void main(String[] args) {
        String email = "SAMPLE_EMAIL";

        String[] deniedIdCharList = { ",", ";", "'", "\"", "[", "]", "|", "\\",
                 "=",  "!", "#", "$", "%", "^", "&", "*", "(", ")",
                "/", "`", "~", ":", "<", ">", "?", "{", "}" };

        int atLoc = email.indexOf("@");
        if (atLoc == -1) {
            System.out.println("fail");
        } else {
            String id = email.substring(0, atLoc);
            String domain = email.substring(atLoc + 1, email.length());

            if (domain.indexOf("@") != -1) {
                System.out.println("fail");
            }

            else {

                for (String deny : deniedIdCharList) {
                    if (id.indexOf(deny) != -1) {
                        System.out.println("fails");
                    }
                    if (domain.indexOf(deny) != -1) {
                        System.out.println("fails");
                    }

                }
                if (id.length() == 0 || domain.length() == 0) {
                    System.out.println("fails");
                }

                int dotIndex = domain.indexOf(".");
                String host = domain.substring(0, dotIndex);
                String extn = domain.substring(dotIndex + 1);
                if (host.length() == 0) {
                    System.out.println("fail");
                }
                if ((extn.length() != 2 && extn.length() != 3 && extn.length() != 5)) {
                    System.out.println("fail");
                }
                if (extn.length() == 5 && extn.indexOf(".") == -1) {
                    System.out.println("fail");
                }

            }

        }

    }
}