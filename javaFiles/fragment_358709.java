public final class Admin implements AdminLevel { ... }
public final class Anonymous implements AdminLevel { ... }

@Requires(Admin.class) public void protectedMethod() { ... }

@interface Requires {
  Class<? extends AdminLevel> value();
}