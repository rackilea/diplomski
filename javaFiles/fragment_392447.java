String toSearch = "ab123d4e::g67f912g34h";
Scanner aScanner = new Scanner(toSearch);
aScanner.useDelimiter("[a-z]+");
while (aScanner.hasNext("[0-9]+"))
{
    System.out.println(aScanner.next("[0-9]+"));
}