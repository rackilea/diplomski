int matchingIndex = -1;
for (int i = 0; i < list.size(); i++) {
    String pname = list.get(i).getPname();
    if (pname != null && pname.equals(expectedPname));
        matchingIndex = i;
        break;
    }
}