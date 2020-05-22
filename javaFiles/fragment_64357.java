@AllArgsConstructor
    @Data
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    static class CompositeKey{
        @EqualsAndHashCode.Include
        Integer k1;
        String k2;
        Long k3;
    }


    public static void main(String[] args) {


        Caffeine<Object, Object> cfein = Caffeine.newBuilder().softValues().maximumSize(200_000);

        IndexedCache<CompositeKey, String> cache = new IndexedCache.Builder<CompositeKey, String>()
                .withIndex(Long.class, ck -> ck.getK3())
                .withIndex(String.class, ck -> ck.getK2())
                .buildFromCaffeine(cfein);


        for(int i=0; i<100; i++){
            cache.put(new CompositeKey(i, String.valueOf(i), Long.valueOf(i)), "sdfsdf");
        }


        for(int i=0; i<10; i++){
            //use equals method of CompositeKey to do equals comp.
            cache.invalidate(new CompositeKey(i, String.valueOf(i), Long.valueOf(i)));
        }

        for(int i=10; i<20; i++){
            //use Long index
            cache.invalidateAllWithIndex(Long.class, Long.valueOf(i));
        }

        for(int i=20; i<30; i++){
            //use String index
            cache.invalidateAllWithIndex(String.class, String.valueOf(i));
        }


        int y = 4;

    }