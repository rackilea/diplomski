try (Scanner scanner = new Scanner(file);
         PrintWriter writer = new PrintWriter(args[1]);) {
        scanner.next();   
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }