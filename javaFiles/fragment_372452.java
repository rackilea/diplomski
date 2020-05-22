String possibleAnswers[] = new String[30];
String alpha[] = new String[30];

for (int index = 0; index < 30; index++) {
    possibleAnswers[index] = "Happy " + index;
    alpha[index] = Integer.toString(index);
}

int a = 0;

StringBuilder sb = new StringBuilder(25);
for (int counter = 0; counter < possibleAnswers.length; counter++) {
    if (counter < 25) {
        sb.append(alpha[counter]).append(": ").append(possibleAnswers[counter]).append("\n");
    }
    if (counter >= 26) {
        sb.append(alpha[26]).append(a).append(": ").append(possibleAnswers[counter]).append("\n");
        a++;
    }
}

System.out.println(sb);