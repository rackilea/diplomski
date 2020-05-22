/**
 * Resolves beans defined in {@link Config},
 * because Spring doesn't want to do it implicitly.
 *
 * Makes possible to write something like
 * @RequestMapping(value="/chart", method=RequestMethod.GET)
 * getChart(HttpServletRequest req, MyBean myBean)
 *
 * and Spring will inject both arguments.
 */
public class MethodArgumentResolver implements HandlerMethodArgumentResolver, BeanFactoryAware {
    private final Set<Class> knownTypes = Config.getDeclaredTypes();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> type = parameter.getParameterType();
        return knownTypes.contains(type);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        Class<?> type = parameter.getParameterType();
        return beanFactory.getBean(type);
    }
}