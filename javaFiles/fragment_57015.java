ArrayList<ArrayList<String>> tmp = solve(a, arr, i + 1, result);
for (ArrayList<String> t : tmp) { // <-- iterating through the result of a recursive call.
    result.add((ArrayList<String>)t.clone());
}
...
return result; // <-- while the recursive call returns the `result` argument.