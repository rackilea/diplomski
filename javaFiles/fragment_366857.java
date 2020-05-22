public static void main(String[] a) {

    Scanner in = new Scanner (System.in);
    String code;
    System.out.print("Enter Course Code: ");
    code = in.nextLine();
    switch (code) {
        case "A": 
             code = "Accounting";
                break;
        case "B": 
             code = "Banking and Finance";
                break;
        case "C": 
             code = "Computer Science";
                break;
        case "D": 
             code = "Dentistry";
                break;
        case "E": 
             code = "Engineering";
                break;
    default:
            System.out.println("Invalid Course Code");
            break;
    }