@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "child_properties"
        ,joinColumns = {
            @JoinColumn(name = "child_id"
                , referencedColumnName = "id"
                ,foreignKey=@ForeignKey(name="CHILD_PROPERTY_FK"
                    , foreignKeyDefinition = "FOREIGN KEY (child_id) references public.child (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE"))
        }
    )
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String,String> properties;