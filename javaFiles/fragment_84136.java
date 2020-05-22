Set<String> regressionUnikey = new HashSet<String>();

    for (int i = 0; i < getListSize(); i++) {
        String key = students.get(i).getUnikey();
        Integer bestGrade = getBestGrade(key);

        Integer recentGrade = getSubmissionFinal(key).getGrade();
        if (recentGrade < bestGrade) {
            regressionUnikey.add(key);
        }
    }