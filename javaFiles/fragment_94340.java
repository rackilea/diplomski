while (true) {
        System.out.println("Would you like to change one of the numbers    (y/n)?");
        choice = kb.next().charAt(0);
        if (choice == 'n')
            break;
        System.out.println("Please enter the index of the number you want to change:");
        indexChange = kb.nextInt();
        System.out.println("Please enter the number you want to change:");
        changedIndex = kb.nextInt();
        elements[indexChange - 1] = changedIndex;
        for (int i = 0; i < elements.length; i++)
            System.out.println(index[i] + elements[i]);

    }