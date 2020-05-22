@Id(generate=TABLE, generator="ADDRESS_TABLE_GENERATOR")
@TableGenerator(
name="ADDRESS_TABLE_GENERATOR", 
    tableName="EMPLOYEE_GENERATOR_TABLE", 
    pkColumnValue="ADDRESS_SEQ"
)
@Column(name="ADDRESS_ID")
public Integer getId() {
    return id;
 }