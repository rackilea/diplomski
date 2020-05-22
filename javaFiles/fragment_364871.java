public void addMark(String student, String subject, int mark) {
    HashMap<String, ArrayList<Integer>> journalContainer = journal.get(student);
    if (journalContainer == null) {
        journalContainer = new HashMap<>();
        journal.put(student,journalContainer);
    }
    ArrayList<Integer> marks = journalContainer.get(subject);
    if (marks == null) {
        marks = new ArrayList<>();
        journalContainer.put(subject, marks);
    }
    marks.add(mark);
}