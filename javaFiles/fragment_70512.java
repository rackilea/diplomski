if (emotion && !height && !strength) {
        System.out.println("You are a short happy person who is weak: I suggest more exercise! ");

    } else if (!emotion&&strength&&height) {
        System.out.println("You are a sad strong person who is tall: I suggest hugging a tree!");

    } else if (!emotion&&!height&&!strength) {
        System.out.println("You are a sad short person who is weak: I am sorry to hear that");

    }