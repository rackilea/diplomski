@Override
public void action() throws TabException {
    JobContainerDTO jobContainer = tab.getRoot().getData();

    JobContainerResolver jcResolver = buildJobContainerResolver(jobContainer);

    JobResolver jResolver = buildJobResolver(job);

    jcResolver.fillWithTabData(tab); 
    jcResolver.fillWithJobData(job);
    jcResolver.fillWithIds(selectedLogin, savedID);

    jResolver.fillWithBasicData(jobContainer, selectedLogin);
}

public JobContainerResolver buildJobContainerResolver(JobContainer jc){
    return new JobContainerResolver(jc);
}

public JobResolver buildJobResolver(Job job){
    return new JobResolver(job);
}