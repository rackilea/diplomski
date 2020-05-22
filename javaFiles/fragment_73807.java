System.out.println(
    Optional.ofNullable(userName) // will be an empty optional if userName is null
            .map(Name::getName)   // will turn to empty optional if getName returns null
            .map("Name is: "::concat) // prepend "Name is: " (only when we have a name)
            .orElse("No Name Found") // get the result string or the alternative
    );