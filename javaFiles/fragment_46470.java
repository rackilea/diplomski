String line = value.toString();
String[] elements = line.split("\\s");
Text year = new Text(elements[0]);
int maxTemp = INTEGER.MIN_VALUE;
int minTemp = INTEGER.MAX_VALUE;
int temp;
for(int i = 1; i<elements.length;i++) {
    temp = Integer.parseInt(elements[i])
    if (temp < minTemp) {
        minTemp = temp;
    } else if (temp > maxTemp) {
        maxTemp = temp;
    }
}

System.out.println("For year " + year + ", the minimum temperature was " + minTemp + " and the maximum temperature was " + maxTemp);