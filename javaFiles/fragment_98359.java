private void displayStudentsReport() {
    System.out.println("***** Display Students Report *****");
    System.out.println();

// build map of <StudentId : List of job for this student>
// perf is much better here because you pass on the job list only once
// whereas before you passed (students.length * currentJobs.length) times
Map<String, List<Job>> jobByStudent = new HashMap<>();
for(Job currentJob : currentJobs) {
    if(jobByStudent.containsKey(currentJob.getStudentID())) {
        jobByStudent.get(currentJob.getStudentID()).add(currentJob);
    } else {
        List<Job> jobs = new ArrayList<>();
        jobs.add(currentJob);
        jobByStudent.put(currentJob.getStudentID(), jobs);
    }
}

for(Student student : students) {
    String comp = student.getStudentID();
    student.printStudentDetails();

    if(jobByStudent.containsKey(comp)) {
        for(Job job : jobByStudent.get(comp)) {
            job.printJobDetails();
        }
    } else {
        System.out.println("Student " + comp + " has no jobs");
    }
}
}