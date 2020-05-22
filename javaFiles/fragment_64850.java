@Override
public String toString() {
    StringBuilder result = new StringBuilder();
    boolean inRun = false;
    for (int i = 0; i < nums.size(); i++) {
        if (i < nums.size() - 1 && nums.get(i).equals(nums.get(i + 1))) {
            if (!inRun) {
                result.append("(");
            }
            result.append(nums.get(i));
            inRun = true;

        } else {
            result.append(nums.get(i));
            if (inRun) {
                result.append(")");
            }
            inRun = false;

        }
    }
    return result.toString();
}