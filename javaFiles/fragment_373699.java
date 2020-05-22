// Split squads by numbers, so we can iterate through each number independently.
private Map<Integer, List<Squad>> splitSquadsByNumbers(List<Squad> squads) {
    Map<Integer, List<Squad>> res = new HashMap<Integer, List<Squad>>();
    for (Squad squad : squads) {
        if (res.get(squad.getNumber()) == null) {
            res.put(squad.getNumber(), new ArrayList<Squad>());
        }
        res.get(squad.getNumber()).add(squad);
    }
    return res;
}

List<Integer> squadNumbers;
Map<Integer, List<Squad>> squadsByNumbers;
Stack<Squad> stack;

// Iterating through each squad with number squadNumbers[position] and try to add to stack, at the end pop it from stack.

private void dfs(int position) {
    if (position == squadNumber.size()) {
        System.out.println(stack.toString());
    } else {
        for (Squad squad : squadsByNumbers.get(squadNumber.get(position))) {
            stack.push(squad);
            dfs(position + 1);
            stack.pop();
        }
    }
}

private void main(List<Squad> squads) {
    squadsByNumbers = splitSquadsByNumbers(squads);
    squadNumber = new ArrayList(squadsByNumber.keySet());
    Collections.sort(squadNumbers);
    stack = new Stack<Squad>();
    dfs(0);
}