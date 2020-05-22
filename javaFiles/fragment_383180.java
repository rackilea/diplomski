@Entity
@IdClass(TableMetadataKey.class)
@Table(name = "table_metadata")
class TableMetadata {
  @Column(name = "column_name")
  @Id
  String columnName;

  @Column(name = "table_name")
  @Id
  String tableName;

  public static class TableMetadataKey implements Serializable {
    String columnName;
    String tableName;
  }
}