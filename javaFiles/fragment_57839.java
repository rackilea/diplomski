import javax.faces.bean.ManagedBean;
            import mypackage.cdi.annotation.BusinessLogic;
            import mypackage.cdi.listener.GuiceListener;
            import com.sun.faces.spi.InjectionProviderException;
            import com.sun.faces.vendor.WebContainerInjectionProvider;

            public class JsfInjectionProvider extends WebContainerInjectionProvider {
                @Override
                public void inject(Object obj) throws InjectionProviderException {
                    if (isManagedBean(obj) || isBusinessLogicObject(obj)) {
                        GuiceListener.injectMembers(obj);
                    }
                }

                /**
                 * As an arbitrary choice, the choice here is to inject only into
                 * {@code @ManagedBean} instances, so that other classes - not written by us
                 * - wouldn't be injected too. This choice could be altered.
                 * 
                 * @param obj
                 *            A JSF bean instance (annotated with @ManagedBean).
                 * @return
                 */
                private boolean isManagedBean(Object obj) {
                    return obj != null && obj.getClass().getAnnotation(ManagedBean.class) != null;
                }

                public static boolean isBusinessLogicObject(Object obj) {
                    return obj != null && obj.getClass().getAnnotation(BusinessLogic.class) != null;
                }
            }