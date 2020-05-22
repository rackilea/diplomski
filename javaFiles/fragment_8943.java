public String pickWinner (String userChoice, String cpuChoice)
    if (userChoice.equalsIgnoreCase("rock")) {
        if (cpuChoice.equalsIgnoreCase("scissors"))
            return "user";
        if (cpuChoice.equalsIgnoreCase("paper"))
            return "computer";
        return "tie";
    }

    if (userChoice.equalsIgnoreCase("scissors")) {
        if (cpuChoice.equalsIgnoreCase("paper"))
            return "user";
        if (cpuChoice.equalsIgnoreCase("rock"))
            return "computer";
        return "tie";
    }

    if (userChoice.equalsIgnoreCase("paper")) {
        if (cpuChoice.equalsIgnoreCase("rock"))
            return "user";
        if (cpuChoice.equalsIgnoreCase("scissors"))
            return "computer";
        return "tie";
    }

    return "???"
}