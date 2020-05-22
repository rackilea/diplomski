List<List<String>> copyOfData = new ArrayList<List<String>>();
for (int i = 0; i < data.size(); i++) {
    copyOfData.add(new ArrayList<String>());
    for (String s : data.get(i)) {
        copyOfData.get(i).add(s);
    }
}

List<List<ProbableValue>> copyOfProbableData = new ArrayList<List<ProbableValue>>();
for (int i = 0; i < probableValues.size(); i++) {
    copyOfProbableData.add(new ArrayList<ProbableValue>());
    for (ProbableValue p : probableValues.get(i)) {
        ProbableValue pNew = new ProbableValue();

        // copy your object here

        copyOfProbableData.get(i).add(pNew);
    }
}