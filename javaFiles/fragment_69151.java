public static void main(String[] args) {
        String text = "Hi:"
                + " "
                + "My Name is Alex and my mail is alexmail@domain.com but you can reply to "
                + "alexreply@other.domain.com."
                + " a@mail.com"
                + " abcd@mail.com";

        String emailPattern = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
                + "      @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

        emailPattern = "(?<emailHead>[_A-Za-z0-9-\\+]{1,3})+?(?<replacementEmailPart>[_A-Za-z0-9-\\+]*)*?(?<emailTail>@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})){1}";

        Pattern p = Pattern.compile(emailPattern);

        Matcher m = p.matcher(text);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String replStr = m.group("replacementEmailPart");
            if (replStr != null) {
                replStr = replStr.replaceAll("[_A-Za-z0-9-\\+]", "*");
            } else {
                replStr = "****";
            }
            m.appendReplacement(sb, m.group("emailHead")
                    + replStr
                    + m.group("emailTail"));
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }