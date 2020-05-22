public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter The Number Of Students: ");
        int n = sc.nextInt();

        StudentPlacement obj[] = new StudentPlacement[n];
        for(int i = 0; i < n; i++) {
            obj[i] = new StudentPlacement();
        }
        System.out.println("Please Enter The Student Details: ");
        for(int i = 0; i < n; i++) {
            System.out.print("Please Enter The Reg. No. :");
            long RegNo = sc.nextLong();
            sc.nextLine();
            System.out.print("Please Enter The Full Name: ");
            String fname = sc.nextLine();
            System.out.print("Please Enter The Semester: ");
            short sem = sc.nextShort();
            System.out.print("Please Enter The GPA: ");
            float gpa = sc.nextFloat();
            System.out.print("Please Enter The CGPA: ");
            float cgpa = sc.nextFloat();
            sc.nextLine();
            System.out.print("Please Enter Branch Name:");
            String branchName = sc.nextLine();
            System.out.println("Please Enter 3 Preferred Choice: ");
            String compList[] = new String[3];
            for(int x = 0; x < 3; x++) {
                compList[x] = sc.nextLine();
            }
            System.out.print("Please Enter The Status Of Placement(0/1): ");
            int statusPlacement = sc.nextInt();
            System.out.print("Please Enter Status Of Internship(0/1): ");
            int statusIntern = sc.nextInt();
            obj[i] = new StudentPlacement(RegNo,fname,sem,gpa,cgpa,branchName,compList,statusPlacement,statusIntern);
            System.out.println();
        }
        for(int i = 0; i < n; i++) {
            obj[i].display();
        }
        sc.close();
    }