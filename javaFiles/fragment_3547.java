for (Candidate i : cands) {
    if (i.getGrade() < 85) {
        if (i.getRegulation() >= 0.5) {
            if (i.getCommunication().equals("average")
                    || i.getCommunication().equals("excellent")) {
                person = i;
                eligibleCandidates.add(i);
            }
        }
    }
}