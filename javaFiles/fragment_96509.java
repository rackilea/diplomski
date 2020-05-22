@Entity
@Table(name = "demo_table")
public class LookUpDemoTable {

@Id
@Column(name = "primary_key")
private String primaryKey;

@Column(name = "text_file_id")
private String textFileId;

public String getPrimaryKey() {
    return primaryKey;
}

public void setPrimaryKey(String primaryKey) {
    this.primaryKey = primaryKey;
}

public String getTextFileId() {
    return textFileId;
}

public void setTextFileId(String textFileId) {
    this.textFileId = textFileId;
}

}