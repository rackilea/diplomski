Scanner scanner = new Scanner(f);

int lineCount = 0;
int caseNumber = -1;
String contents = "";
while(scanner.hasNextLine())
{
    lineCount++;
    String line = scanner.nextLine().trim();
    if(lineCount == 1)
    {
        if(line.startsWith("case"))
        {
            String subStr = line.substring(line.indexOf("e") + 1,
                line.indexOf(":"));
            if(isNumeric(subStr))
                caseNumber = Integer.parseInt(subStr);
        }
    }
    else if(isNumeric(line))
        contents += line;
}

scanner.close();

System.out.println("Case Number: " + caseNumber);
System.out.println("Case Contents: " + contents);
System.out.println("Line Count: " + lineCount);