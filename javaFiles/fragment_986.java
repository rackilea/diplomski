public class RecipientPreference {

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @AttributeOverride(name = "id", column = @Column(name = CommunicationPreferenceTable.COLUMN_LIST_ID, nullable = false))
  @JoinColumn(name = CommunicationPreferenceTable.COLUMN_LIST_ID)
  private CommunicationPreference communicationPreference;

}