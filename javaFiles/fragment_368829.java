Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();
int[] array = new int[input.length()];

for(int i = 0; i < input.length(); i++){
    array[i] = Integer.parseInt(Character.toString(input.charAt(i)));
}