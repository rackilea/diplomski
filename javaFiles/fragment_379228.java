public interface ConfigWrapper {
   public String getParameter(String parameter);

public class ConfigWrapperImpl implements ConfigWrapper{
   public String getParameter(String parameter){
      return Config.getParameter(parameter);
   }
}