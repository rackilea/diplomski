@Transactional
public Job pickJob() {
    Job job = jobRepository.findFirstByStatus(Status.NOT_PROCESSED);
    job.setStatus(Status.PROCESSING);
    Job saved jobRepository.save(job);
    return saved;
}