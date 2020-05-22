...
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"close_type", "agreement"})
}) 
Contract implements Serializable  {
    ...
}