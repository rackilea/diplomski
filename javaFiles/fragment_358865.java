@Entity
public class PlayerEntity {

  @Column(nullable = false)
  private Integer a;

  @Column(nullable = false)
  private Integer b;

  @Formula("a - b") 
  private Integer delta
}

List<PlayerEntity> playerList = (List<PlayerEntity>)session.createCriteria(PlayerEntity.class)
.add(Restrictions.gt("delta", 5).list();