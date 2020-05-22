boolean candidateFound = false;
for (var i = 0; i < listak.size(); i++) {
    var actualCandidate = listak.get(i);

    if (actualCandidate.name.equals(surname + " " + firstname)) {
        System.out.println(actualCandidate.name);
        System.out.println("Number of votes " + actualCandidate.votes);

        candidateFound = true;
        break;
    }
}

if (!candidateFound) {
    System.out.println("No candidate with this name");
}