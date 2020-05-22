@progressPercentage(job) = @{
    job.getTotalTaskCount/job.getFinishedTaskCount.toDouble
}
@for((job,index) <- jobList.zipWithIndex) {
    // Rest of your template structure here, use like @progressPercentage(job)
}