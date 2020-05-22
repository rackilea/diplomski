@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")
   private Long userId;

   @ManyToOne
   @JoinColumn(name = "group_id_user")
   @Expose(serialize = false)
   private Group group;

   @Column(name = "group_id_user", updatable = false, insertable = false)
   private Long groupId;     

   @Column(name = "name")
   private String name;

   ...
   // getters and setters....   
}