public enum PluginTypes {
   ROTATING_LINE { Plugin create(int x, int y){
         return new plugin.rotatingline.RotatingLine(x,y);} },
   SNOW_SYSTEM { Plugin create(int x, int y){
         return new plugin.snow.SnowSystem(x,y);} };

   abstract Plugin create(int x, int y);
}

public interface Plugin {
  //...
}