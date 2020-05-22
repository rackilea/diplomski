String s = new StringBuilder()
        .append("Hello ")
        .append(person.getFirstName())
        .append(", please say hello to your father, ")
        .append(person.getFather().getFirstName())
        .append(".")
        .toString();