boolean found = false;
for (int i : myList) {
    if (i == testNumber)
        found = true;
}

if (!found)
    System.out.println("no element equals " + testNumber);