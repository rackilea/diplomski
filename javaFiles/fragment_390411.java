public static void main(String[] args) {
    String input = "Response: Success\n"+
                    "Message: Extension Status\n"+
                    "Exten: 1234\n"+
                    "Context: from-sip\n"+
                    "Hint: DS/5678\n"+
                    "Status: 9";

    String exten = input.substring(input.indexOf("Exten: ")+"Exten: ".length(), input.indexOf("Context: ")).trim();
    String status = input.substring(input.indexOf("Status: ")+"Status: ".length(),input.length()).trim();

    System.out.println("Exten: "+exten);
    System.out.println("Status: "+status);
}