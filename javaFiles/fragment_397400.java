private List<Task> spawn(Task original, Frequency frequency) {

    Date sd = original.getSd();
    Date ed = original.getEd();

    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(sd.getTime());

    List<Task> tasks = new ArrayList<Task>();
    for (; cal.getTimeInMillis() <= ed.getTime(); cal.add(frequency.getFrequency(), frequency.getMultiplier())) {
        Task task = original.clone();
        task.setSd(cal.getTime());

        tasks.add(task);
    }

    return tasks;
}

public enum Frequency {

    WEEKLY(Calendar.WEEK_OF_YEAR, 1),
    BIWEEKLY(Calendar.WEEK_OF_YEAR, 2),
    MONTHLY(Calendar.MONTH, 1),
    QUARTERLY(Calendar.MONTH, 3);

    private int frequency;
    private int multiplier;

    Frequency(int frequency, int multiplier) {
        this.frequency = frequency;
        this.multiplier = multiplier;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getMultiplier() {
        return multiplier;
    }

}