if(wconfig.reloadOnClassChange) 
{
    if(managedClassReload) 
    {
        if(wconfig.inplace) // <-- your problem, you are running inplace
        {
            log.info 'file {} is in managed output of {}, servlet-container will not be restarted', f, wconfig.projectPath
        }
        else 
        {
            log.info 'file {} is in output of {}, but it runs as WAR, servlet-container will be restarted', f, wconfig.projectPath
            webAppConfigsToRestart.add(wconfig)
        }
    } 
    else 
    {
       log.info 'file {} is in output of {}, servlet-container will be restarted', f, wconfig.projectPath
       webAppConfigsToRestart.add(wconfig)
    }
}