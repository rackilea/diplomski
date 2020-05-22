public class Reports extends Model {

...

  public static List<Reports> findByProject(Projects project) {
    return find.fetch("project").where().eq("project.id", project.id).findList();
  }
}