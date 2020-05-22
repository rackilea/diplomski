@Configuration
@ConfigurationProperties
@Getter
@Setter
public class Configclass {

  List<Flow> flow;
}

@Getter
@Setter
public class Flow {

  public String name;
  public String url;
}