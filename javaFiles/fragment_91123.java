if (keyboardInput.nextLine().equalsIgnoreCase("INSERT") 
              && !allUsers.contains(inputUser))    {
        allUsers.add(inputUser);
        System.out.println("User has been successfully added to your list.");
    }
    else
        System.out.println("This user already exists on the list!");