public static List<List<String>> cartesianNoRecursive(List<List<String>> data) {
    int total = 1;
    for (int i = 0; i < data.size(); i++) {
        total *= data.get(i).size();
    }
    List<List<String>> result =  new ArrayList<>(total);
    for (int i = 0; i < total; i++) {
        result.add(new ArrayList<>());
    }
    int now = 1;
    // used times for every element in one loop
    int itemLoopNum = 1;
    // total  times of every element
    int loopPerItem = 1;
    for (int i = 0; i < data.size(); i++) {
        List<String> temp = data.get(i);
        now = now * temp.size();
        //index of target result
        int index = 0;
        int currentSize = temp.size();
        itemLoopNum = total / now;
        loopPerItem = total / (itemLoopNum * currentSize);
        // index of data
        int dataIndex = 0;
        for (int j = 0; j < temp.size(); j++) {
            for (int k = 0; k < loopPerItem; k++) {
                if (dataIndex == temp.size()) {
                    dataIndex = 0;
                }
                for (int m = 0; m < itemLoopNum; m++) {
                    result.get(index).add(temp.get(dataIndex));
                    index++;
                }
                dataIndex++;

            }
        }
    }
    return result;
}