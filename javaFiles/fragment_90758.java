public class PersonEntity implements Serializable {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parentID")
  @Fetch(FetchMode.SELECT)
  private PersonEntity parent;

  @Basic(fetch = FetchType.LAZY)
  @Formula("select p.name from person p where p.id = parentID")
  private String parentName;
}