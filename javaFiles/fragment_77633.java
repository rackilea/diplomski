Scanner scan = new Scanner(System.in);
int select = 0;
do {
    System.out.println("Enter your option");
    select = scan.nextInt();
    if (select == 1) {
        ad.AddListIntoArray();
    } else if (select == 2) {
        ad.PrintMarkFromTheArray();
    } else if (select == 3) {
        ad.PrintNameFromTheArray();
    } else if (select == 4) {
        ad.PrintNameMarkFromTheArray();
    } else if (select == 5) {
        ad.SendMark();
    }else if (select == 6) {
        System.out.println("Exiting...");
    }
    else {
        System.out.println("invalid input");
    }
} while (select != 6);