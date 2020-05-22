import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringCacheTest.Config.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class SpringCacheTest {

    private final static String CACHE_NAME = "testCache";
    private final static AtomicInteger methodInvocations = new AtomicInteger(0);

    public interface ICacheableService {

        String methodA(int length);

        String methodB(String name);
    }

    @Resource
    private ICacheableService cache;

    @Test
    public void testNestedCaching() {

        String name = "test";
        cache.methodB(name);
        assertEquals(methodInvocations.get(), 2);

        cache.methodA(name.length());
        // should only be 2 as methodA for this length was already invoked before
        assertEquals(methodInvocations.get(), 2);
    }

    @Configuration
    @EnableCaching
    public static class Config {

        @Bean
        public CacheManager getCacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(CACHE_NAME)));
            return cacheManager;
        }

        @Bean
        public ICacheableService getMockedEntityService() {
            return new ICacheableService() {
                private final Random random = new Random();

                @Autowired
                ApplicationContext context;

                @Override
                @Cacheable(value = CACHE_NAME, key = "#root.methodName.concat('_').concat(#p0)")
                public String methodA(int length) {
                    methodInvocations.incrementAndGet();
                    System.out.println("Invoking methodA");
                    char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < length; i++) {
                        sb.append(chars[random.nextInt(chars.length)]);
                    }
                    String result = sb.toString();
                    System.out.println("Returning " + result + " for length: " + length);
                    return result;
                }

                @Override
                @Cacheable(value = CACHE_NAME, key = "#root.methodName.concat('_').concat(#p0)")
                public String methodB(String name) {
                    methodInvocations.incrementAndGet();
                    System.out.println("Invoking methodB");
                    ICacheableService cache = context.getBean(ICacheableService.class);
                    String rand = cache.methodA(name.length());
                    String result = name + "_" + rand;
                    System.out.println("Returning " + result + " for name: " + name);
                    return result;
                }
            };
        }
    }
}