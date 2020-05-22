// String[] splitJobs = new String[2];
String[] splitJobs = jobs.split("\\s*,\\s*"); // <-- creates a "dynamic" array.
this.serviceid = Integer.parseInt(splitJobs[0]);
this.jobID = Integer.parseInt(splitJobs[1]);
int[] serviceNumber = new int[splitJobs.length - 2];
for (int i = 2; i < splitJobs.length; i++) {
    this.serviceNumber[i - 2] = Integer.parseInt(splitJobs[i]);
}