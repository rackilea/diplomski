public interface AsdDAO<T>{
    public Set<T> getEntities();
}

public class AsdPlayerDao implements AsdDAO<Player>{
   public Set<Player> getEntities();
}

public class AsdPartnerDao implements AsdDAO<Player>{
   public Set<Partner> getEntities();
}