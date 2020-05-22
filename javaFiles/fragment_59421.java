private static Scanner userInput = new Scanner(System.in);
StringBuilder sb = new StringBuilder();

String line = userInput.nextLine();
while(!line.equalsIgnoreCase("end"))
{
    sb.append(line).append('\n');
    line = userInput.nextLine();
}

String textBody = sb.toString();