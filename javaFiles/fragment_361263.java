Emyployee employee = ...
Manager manager = ...
List<ManagerReportProject> managerReportProjects= employee.getManagerReportProjects()
for(ManagerReportProject managerReportProject: managerReportProjects )
{
    if(manager.equals(managerReportProject.getManager()))
    {
       Project project = managerReportProject.getProject();

       managerReportProject.setStartDate(...);
       managerReportProject.setEndDate(...);
       managerReportProject.setperformance(...);
       ...

    }

}