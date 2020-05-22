#============================================================================
# Configure Main Scheduler Properties 
#============================================================================

org.quartz.scheduler.instanceName = BjondScheduler
org.quartz.scheduler.instanceId = AUTO

#============================================================================
# Configure ThreadPool 
#============================================================================

org.quartz.threadPool.class = org.quartz.simpl.SimpleThreadPool
org.quartz.threadPool.threadCount = 5

#============================================================================
# Configure JobStore 
#============================================================================

org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreCMT
org.quartz.jobStore.driverDelegateClass=org.quartz.impl.jdbcjobstore.PostgreSQLDelegate
org.quartz.jobStore.useProperties = false
org.quartz.jobStore.tablePrefix=QRTZ_
org.quartz.jobStore.isClustered = true
org.quartz.jobStore.clusterCheckinInterval = 5000

org.quartz.scheduler.wrapJobExecutionInUserTransaction = true
org.quartz.scheduler.userTransactionURL = java:jboss/UserTransaction

org.quartz.jobStore.dataSource = PostgreSQLDS
org.quartz.jobStore.nonManagedTXDataSource = PostgreSQLDSNoJTA

org.quartz.dataSource.PostgreSQLDSNoJTA.jndiURL=java:jboss/datasources/PostgreSQLDSNoJTA
org.quartz.dataSource.PostgreSQLDS.jndiURL=java:jboss/datasources/PostgreSQLDS


#============================================================================
# Configure Logging
#============================================================================
#org.quartz.plugin.jobHistory.class=org.quartz.plugins.history.LoggingJobHistoryPlugin
#org.quartz.plugin.jobHistory.jobToBeFiredMessage=Bjond Job [{1}.{0}] to be fired by trigger [{4}.{3}] at: {2, date, HH:mm:ss MM/dd/yyyy} re-fire count: {7}
#org.quartz.plugin.jobHistory.jobSuccessMessage=Bjond Job [{1}.{0}] execution complete and reports: {8}
#org.quartz.plugin.jobHistory.jobFailedMessage=Bjond Job [{1}.{0}] execution failed with exception: {8}
#org.quartz.plugin.jobHistory.jobWasVetoedMessage=Bjond Job [{1}.{0}] was vetoed. It was to be fired by trigger [{4}.{3}] at: {2, date, dd-MM-yyyy HH:mm:ss.SSS}