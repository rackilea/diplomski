String input = "1950/00/00;1953/00/00;1958/00/00;1960/00/00;1962/0";

String[] parts = input.split(";");

for (String part : parts) {
    System.out.println(part);
}