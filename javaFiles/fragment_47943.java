public class BootStrap {


public static void main(String[] args) throws Exception{
    URL url = new URL("http://maven.aliyun.com/nexus/content/groups/public/org/springframework/spring-context/4.3.1.RELEASE/spring-context-4.3.1.RELEASE.jar?spm=0.0.0.0.kG1Pdw&file=spring-context-4.3.1.RELEASE.jar");
    URL url2= (new File("D:\\test\\target.jar").toURI().toURL());
    URLClassLoader classLoader = new URLClassLoader(new URL[]{url,url2});
    Class<?> clz = classLoader.loadClass("com.zhuyiren.Target");
    Object main = clz.newInstance();
    Method test = clz.getMethod("start");
    test.invoke(main);
    }
}