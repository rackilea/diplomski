import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.BeanInvoker;
import org.apache.cxf.service.invoker.Invoker;

public class MyServiceInterceptor extends AbstractSoapInterceptor
{
    public MyServiceInterceptor() 
    {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(SoapMessage p_message) throws Fault 
    {
        final Exchange exchange = p_message.getExchange();
        final Endpoint endpoint = exchange.get(Endpoint.class);
        final Service service = endpoint.getService();
        final Invoker invoker = service.getInvoker();

        if (invoker instanceof BeanInvoker)
        {
            BeanInvoker bi = (BeanInvoker)invoker;
            Object serviceObj = bi.getServiceObject(null);
            if (Proxy.isProxyClass(serviceObj.getClass()))
            {
                InvocationHandler ih = Proxy.getInvocationHandler(serviceObj);
                if (ih instanceof MyWebServiceInvocationHandler)
                {
                    MyWebServiceInvocationHandler h = (MyWebServiceInvocationHandler)ih;
                    h.setSoapMessage(p_message);
                }
            }
        }
    }
}