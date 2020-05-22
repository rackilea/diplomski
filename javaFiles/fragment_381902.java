@OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="user_id" ,referencedColumnName = "user_id"),
        @JoinColumn(name="manager_id" ,referencedColumnName = "manager_id")
        ,@JoinColumn(name="assessor_id" ,referencedColumnName = "assessor_id")
    })
    @Cascade(CascadeType.ALL)