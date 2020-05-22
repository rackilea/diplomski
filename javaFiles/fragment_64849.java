@Override
public void resultChanged(LookupEvent le)
{
    Collection<? extends JFlavourProjectBean> allProjects = result.allInstances();
    if (!allProjects.isEmpty()) {
        JFlavourProjectBean project = allProjects.iterator().next();
        this.activeProject = project;
        SortedSet<String> categories = project.getCategories();
        categoriesListModel.clear();
        for (Iterator<String> it = categories.iterator(); it.hasNext();) {
            categoriesListModel.addElement(it.next());
        }
        tmpLabel.setText(project.getName());
    } else {
        // do nothing if no projects are in the lookup
    }
}