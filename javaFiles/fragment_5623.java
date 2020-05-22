@Configuration
public class MyConfiguration {

    private Serwis baseSerwis() {
        Serwis base =  new Serwis();
        base.setA(11);
        Map map = new HashMap();
        map.put(111, 111);
        base.setM(map);
        return base;
    }

    @Bean
    public Serwis absSerwis() {
        return baseSerwis();
    }

    @Bean
    public Serwis defSerwis() {
        Serwis defSerwis = baseSerwis();
        defSerwis.setB(12);
        return defSerwis;
    }
}