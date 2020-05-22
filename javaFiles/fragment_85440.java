public static void main(String[] args) {
    int ACount = 0;
    int BCount = 0;
    int CCount = 0;
    int DCount = 0;

    Scanner input = new Scanner(System.in);
    boolean askingForName = false;
    boolean first = true;
    System.out.println("Enter name: ");
    while(true) {
        if (first) {
            String nameInput = input.nextLine();

            first = false;
            continue;
        }
        if (askingForName) {
             System.out.println("Enter name: ");
                String nameInput = input.nextLine();
                askingForName = false;

        }else {
            System.out.println("Enter grade: ");
            String gradeInput = input.nextLine();

            if (gradeInput.equalsIgnoreCase("A")) {
                ACount++;

            }else if (gradeInput.equalsIgnoreCase("B")) {
                BCount++;
            }else if (gradeInput.equalsIgnoreCase("C")) {
                CCount++;
            }else if (gradeInput.equalsIgnoreCase("D")) {
                DCount++;
            }



             askingForName = true;
        }


        if (!input.hasNextLine())
            break;

    }
     System.out.printf("%n%nGrade report%n%nA: %d%nB: %d%nC: %d%nD: %d%n", ACount, BCount, CCount, DCount);
}