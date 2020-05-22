String input = "[1,Mumbai][2,Delhi][3,Chennai]";
String[][] abuscat;
String[] parts = input.split("(?<=\\])(?=\\[)");
abuscat = new String[parts.length][2];

for (int r=0; r < parts.length; ++r) {
    abuscat[r][0] = parts[r].replaceAll("[\\[\\]]", "").split(",")[0];
    abuscat[r][1] = parts[r].replaceAll("[\\[\\]]", "").split(",")[1];
}

System.out.println(Arrays.deepToString(abuscat));