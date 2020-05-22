String[] nums = s.replaceAll(" ", "").replaceAll("\\+", " ")
        .replaceAll("-", " -").split(" ");
int res = 0;
for (String n : nums) {
    if (!n.isEmpty())
        res += Integer.parseInt(n);
}