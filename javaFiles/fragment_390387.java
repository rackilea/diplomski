@Override
    public void dialogSelectedItems(List<String> items) {
        List<SubjectModel> list = new ArrayList<>();
        for (String s : items) {
            subjects.add(s);
        }