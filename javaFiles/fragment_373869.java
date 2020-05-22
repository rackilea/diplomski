@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired(required = false)
    private HelloService helloService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("hello");
        if (helloService != null) {
            helloService.hello();
            removeBean("helloService");
        }

        return modelAndView;
    }

    private void removeBean(String beanName) {
        BeanDefinitionRegistry factory = (BeanDefinitionRegistry) applicationContext
                .getAutowireCapableBeanFactory();
        factory.removeBeanDefinition(beanName);
        clearCache(factory);
    }

    private void clearCache(BeanDefinitionRegistry beanFactory){
        AutowiredAnnotationBeanPostProcessor processor = null;

        for (BeanPostProcessor beanPostProcessor : ((DefaultListableBeanFactory) beanFactory).getBeanPostProcessors()){
            if (beanPostProcessor.getClass().equals(AutowiredAnnotationBeanPostProcessor.class)){
                processor = (AutowiredAnnotationBeanPostProcessor) beanPostProcessor;
            }
        }

        try {
            Field injectionMetadataCache = processor.getClass().getDeclaredField("injectionMetadataCache");
            injectionMetadataCache.setAccessible(true);
            Method clear = Map.class.getMethod("clear");
            clear.invoke( injectionMetadataCache.get(processor));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}