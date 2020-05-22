public String makeProSys() {
    newProSys = new ProjectFileSystem(proclassid, projectid,     classification, projectName);

    newProject = proServ.findByProjectId(projectid);
    projectName = newProject.getProjectName();
    newProSys.setProjectName(projectName);

    newProClass = facade.findByContactId(proclassid);
    classification = newProClass.getClassification();
    newProSys.setFolderName(classification);

    profilFacade.save(newProSys);
    return showProSys();
}