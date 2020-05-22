public List<Job> getJobChildren(final Job job, final List<Job> result) {
    if (job == null) {
        return result;
    }

    result.add(job);
    if(job.getChildren() != null){
        for(Job current : job.getChildren()){
            getJobChildren(current, result);
        }
    }

    return result;
}