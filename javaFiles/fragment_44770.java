List<List<String>> listOfTuples(<List<List<String>> list) {
    ArrayList<List<String>> result = new ArrayList<List<String>>();
    List<String> prefix = new ArrayList<String>();
    recurse(0, list, prefix, result);
    return result;
}

void recurse(int index,
             List<List<String>> input,
             List<String> prefix,
             List<List<String>> output)
{
    if (index >= input.size()) {
        output.add(new ArrayList<String>(prefix));
    } else {
        List<String> next = input.get(index++);
        for (String item : next) {
            prefix.add(item);
            recurse(index, input, prefix, output);
            prefix.remove(item);
        }
    }
}