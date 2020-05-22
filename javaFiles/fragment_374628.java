public static void main(String[] args) {
    String res = "JSGF V1.0;grammar numbers;public <accion> = (one| two| three);";
    String answer = res.substring(res.indexOf("(") + 1, res.indexOf(")"));
    String[] numbers = answer.split("[^\\w]+"); // split on non-word character
    for (String number : numbers) {
        System.out.println(number);
    }
}