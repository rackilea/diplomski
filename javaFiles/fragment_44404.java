System.out.print("Employee's Last Name: ");
    String inputName = null;
    String inputStatus = null;
    if (scanner.hasNext())
        inputName = scanner.next();
    System.out.print("Employment Status (F or P): ");
    if (scanner.hasNext())
        inputStatus = scanner.next();

    if ("F".equalsIgnoreCase(inputStatus)) {
        // some code
    } else if ("P".equalsIgnoreCase(inputStatus)) {
        // some code
    } else {
        System.out.println("I don't understand...");
    }