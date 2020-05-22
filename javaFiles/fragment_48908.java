Set<Integer> seen = new HashSet<Integer>();
boolean halfSeen = false;
for (int num : numberList) {
    if (num == requiredSum/2 && requiredSum % 2 == 0) {
        if (halfSeen) return true;
        halfSeen = true;
    } else {
        seen.add(num);
    }
}
for (int num : seen) {
    if (seen.contains(requiredSum - num)) return true;
}
return false;