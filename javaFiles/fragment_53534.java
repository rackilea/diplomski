public static void main(String[] args) {

    String input = "Street Road Patta 55,053888 Alur Satta,Keidaj";

    final String[] lines = input.split(",");
    for(String line : lines) {
        System.out.println(center(line, 48));
    }

}