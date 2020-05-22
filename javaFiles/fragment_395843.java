class Test   {
    Long id;    

    @ElementCollection
    @JoinTable(name = "CATEGORY_JOIN_TABLE", joinColumns = @JoinColumn(name = "category_join_table_id_column"))
    @MapKeyJoinColumn (name = "category_id")
    @Column(name = "id")
    Map<Category, Long> splitUp;
}