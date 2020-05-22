@RequestMapping("/edit/{jobId}")
public String editJob(@PathVariable("jobId") Integer jobId,Model model){
    //model.addAttribute("id",jobId); this is wrong
    Job job = jobService.getJobById(jobId);
    //write method in jobservice to get job by id i.e. getJobById(Integer jobId);
    model.addAttribute("job",job)
    return "edit";
}