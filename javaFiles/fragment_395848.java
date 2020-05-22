public class PermutationWithinSubsection {
public static void main(String[] args) {
    List<String> alphabets = Arrays.asList("a","b","c","d","e","f","g");
    List<Integer> values = Arrays.asList(25,18,18,18,14,14,12);
    // Step 1 start
    Map<Integer, List<String>> valuesToListMap = new TreeMap<>(Collections.reverseOrder()); // Order the map in reverse order of values
    for(int i=0; i<alphabets.size(); i++) {
        if(valuesToListMap.containsKey(values.get(i))) {
            List<String> temp = valuesToListMap.get(values.get(i));
            temp.add(alphabets.get(i));
            valuesToListMap.put(values.get(i),temp);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(alphabets.get(i));
            valuesToListMap.put(values.get(i), temp);
        }
    }
    // Step 1 end

    // Step 2 start
    List<List<String>> permutationsList = new ArrayList<>();
    for(List<String> ip: valuesToListMap.values()) {
       List<String> result = new PermutationWithinSubsection().permute(ip);
        permutationsList.add(result);
    }
    // Step 2 end

    // // Step 3 start
    int count = 1;
    List<String> l1 = permutationsList.get(0);
    List<String> r = new PermutationWithinSubsection().merge(l1, permutationsList, count);
    // // Step 3 end
    System.out.println("r = " + r);
}

/**
 * Find permutations of input list using backtracking
 * @param ip
 * @return
 */
private List<String> permute(List<String> ip) {
    List<String> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), ip);
    return list;
}

private void backtrack(List<String> list, ArrayList<String> tempList, List<String> nums) {
    if(tempList.size() == nums.size()){
        StringBuilder sb = new StringBuilder();
        for(String s: tempList) {
            sb.append(s);
        }
        list.add(sb.toString());
    } else{
        for(int i = 0; i < nums.size(); i++){
            if(tempList.contains(nums.get(i))) continue; // element already exists, skip
            tempList.add(nums.get(i));
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}


/**
 * Keep on merging lists till we have merged all
 * @param l1
 * @param resultLists
 * @param count
 * @return
 */
private List<String> merge(List<String> l1, List<List<String>> resultLists, int count) {
    if(count == resultLists.size()) {
        return l1;
    }
    List<String> l2 = resultLists.get(count);
    List<String> f = new ArrayList<>();
    for(String s1: l1) {
        for(String s2: l2) {
            f.add(s1+s2);
        }
    }
    return merge(f,resultLists,++count);
}