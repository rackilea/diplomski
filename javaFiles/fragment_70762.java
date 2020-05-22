String turtle1 = "         _\r\n     .-./*)\r\n   _/___\\/\r\n     U U\r\n";
String turtle2 = "         _\r\n     .-./*)\r\n   _/___\\/\r\n     U U\r\n";
String[] turtle1Lines = turtle1.split("\r\n");
String[] turtle2Lines = turtle2.split("\r\n");
StringBuilder sb = new StringBuilder();
int turtle1Width = 0;
for (int i = 0; i < 4; i++) {
    if (turtle1Lines[i].length() > turtle1Width) {
        turtle1Width = turtle1Lines[i].length();
    }
}
for (int i = 0; i < 4; i++) {
    sb.append(turtle1Lines[i]);
    for (int j = turtle1Width - turtle1Lines[i].length(); j > 0; j--) {
        sb.append(' ');
    }
    sb.append(turtle2Lines[i]);
    sb.append("\r\n");
}
String turtles = sb.toString();