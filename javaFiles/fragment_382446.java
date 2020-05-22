private static List<String> appendStrings(List<String> original, int group) throws Exception {
    if (original.size() % group == 0) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < original.size(); i += group) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < group; ++j) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(original.get(i + j));
            }
            newList.add(sb.toString());
        }

        return newList;
    } else {
        throw new Exception("MyClass::appendStrings() ---> the group value must be a factor of the size of the original list");
    }
}