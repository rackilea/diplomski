class Process implements Comparable<Process> {

    private String processName;
    private Date arrival;

    public Process(String processName, Date arrival) {
        this.processName = processName;
        this.arrival = arrival;
    }

    public String getProcessName() {
        return processName;
    }
    public Date getArrival() {
        return arrival;
    }

    @Override
    public int compareTo(Process p) {
        return this.getArrival().compareTo(p.getArrival());
    }
}