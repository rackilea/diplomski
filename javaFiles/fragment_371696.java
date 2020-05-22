@Transactional
public void updateProject(Project project) {
    Project itemFromDbs = this.getById(project.getId());
    if (itemFromDbs != null) {
        itemFromDbs.setTaskPlans(project.getTaskPlans());
        entityManager.merge(itemFromDbs);//so i wont persist a detached entity
        entityManager.flush();
    }
}