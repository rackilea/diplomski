class Entry {
    final String serverName;
    final int serverNumber;
    final String jobName;
    final String jobVersion;

    Entry(Version version, Job job) {
        this.serverName = version.serverName;
        this.serverNumber = version.serverNumber;
        this.jobName = job.name;
        this.jobVersion = job.version;
    }
}