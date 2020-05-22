@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Person")
public class Person {

  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  @PrimaryKeyJoinColumn
  @Fetch(FetchMode.JOIN)
  private NickName nickName;
}

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "nickname")
public class NickName {

  @Id
  private UUID id;

  @Column(name = "nick")
  private String nick;
}