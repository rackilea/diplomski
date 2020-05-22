public class Menu {
  @Transient
  private Set<Menu> pageChildren = new HashSet<Menu>();       //CHANGED

  @Column(name = "pageParent")
  private Integer pageParent;

  @Column(name = "pageId")
  private Integer pageId;

  ...