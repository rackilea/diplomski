package util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/**
 * Disposable weak reference calls you back when referent has been disposed. You can also create proxy to the referent to emulate direct access.
 * 
 * <pre>
 * public class Example {
 *     public interface I {
 *         // interface referent is implementing to create a proxy
 *     }
 * 
 *     public static final class T implements I {
 *         public String toString() {
 *             return "blah";
 *         }
 *     }
 * 
 *     private WeakReference&ltT&gt wr;
 *     private I wrp;
 *     private List&ltObject&gt list = new LinkedList&ltObject&gt();
 * 
 *     private void testWeakRef() {
 *         T o = new T();
 *         wr = new DisposableWeakReference&ltT&gt(o) {
 *             public void dispose(Object disposable) {
 *                 list.remove(disposable);
 *             }
 *         };
 *         list.add(wr);
 *         wrp = DisposableWeakReference.newWeakReferenceProxy(new DisposableWeakReference&ltI&gt(o) {
 *             public void dispose(Object disposable) {
 *                 list.remove(disposable);
 *                 Example.this.wrp = null;
 *             }
 *         }, I.class);
 *         list.add(wrp);
 *     }
 * 
 *     public static void main(final String[] args) throws Exception {
 *         Example exmple = new Example();
 *         exmple.testWeakRef(); // try to replace with exact implementation
 * 
 *         System.out.println("exmple.wr.get() " + exmple.wr.get()); // blah
 *         System.out.println("exmple.wrp " + exmple.wrp); // blah
 *         System.out.println("exmple.list.contains(exmple.wr) " + exmple.list.contains(exmple.wr)); // true
 *         System.out.println("exmple.list.contains(exmple.wrp) " + exmple.list.contains(exmple.wrp)); // true
 *         System.gc();
 *         Thread.sleep(10);
 *         System.out.println("exmple.wr.get() " + exmple.wr.get()); // null
 *         System.out.println("exmple.wrp " + exmple.wrp); // null or exception
 *         System.out.println("exmple.list.contains(exmple.wr) " + exmple.list.contains(exmple.wr)); // false
 *         System.out.println("exmple.list.contains(exmple.wrp) " + exmple.list.contains(exmple.wrp)); // false
 *     }
 * }
 * 
 * <pre>
 * 
 * @param <T> weak reference referent type
 * @author Mykhaylo Adamovych
 */
@SuppressWarnings({ "rawtypes" })
public abstract class DisposableWeakReference<T> extends WeakReference<T> {
    public static class DisposedException extends RuntimeException {
        private static final long serialVersionUID = -1176608195614694732L;

        public DisposedException() {
            super();
        }

        public DisposedException(String message) {
            super(message);
        }

        public DisposedException(String message, Throwable cause) {
            super(message, cause);
        }

        public DisposedException(Throwable cause) {
            super(cause);
        }
    }

    private static class ReferenceProxy<T> implements InvocationHandler {
        private final DisposableWeakReference<T> reference;

        public ReferenceProxy(DisposableWeakReference<T> reference) {
            this.reference = reference;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("equals".equals(method.getName()))
                return proxy == args[0];
            else if ("hashCode".equals(method.getName()))
                return hashCode();
            T referent = reference.get();
            if (referent == null)
                throw new DisposedException("Referent has been disposed.");
            return method.invoke(referent, args);
        }
    }

    private static class WeakReferenceDisposerThread extends Thread {
        WeakReferenceDisposerThread() {
            super("Weak Reference Disposer");
        }

        @Override
        public void run() {
            while (true)
                try {
                    DisposableWeakReference<?> reference = (DisposableWeakReference<?>) queue.remove();
                    Object disposable = reference.proxy;
                    if (disposable == null)
                        disposable = reference;
                    reference.dispose(disposable);
                } catch (Throwable e) {
                    // ignore any exception while disposing
                }
        }
    }

    private static final ReferenceQueue queue = new ReferenceQueue();

    static {
        Thread disposer = new WeakReferenceDisposerThread();
        disposer.setPriority(Thread.MAX_PRIORITY - 2);
        disposer.setDaemon(true);
        disposer.start();
    }

    /**
     * You can use referent directly without {@link #get()}. Runtime exception will rise in case referent has been disposed by GC. You can use
     * {@link #dispose(Object)} to deal with proxy also.
     * 
     * @param reference
     *            disposable weak reference
     * @param clazz
     *            referent interface class
     * @param <T>
     *            referent type
     * @param <I>
     *            referent interface to create a proxy
     * @return referent proxy using weak reference
     */
    public static <I> I newWeakReferenceProxy(DisposableWeakReference<I> reference, Class<I> clazz) {
        I proxy = ReflectUtils.<I>newProxyInstance(new ReferenceProxy<I>(reference), clazz);
        reference.proxy = proxy;
        return proxy;
    }

    private Object proxy;

    public DisposableWeakReference(T referent) {
        super(referent, queue);
    }

    /**
     * Remove this weak reference wrapper from whatever when referent has been garbage collected.
     * 
     * @param disposable
     *            either this reference instance or proxy instance created by {@link #newWeakReferenceProxy(DisposableWeakReference, Class)}
     * @see WeakHashMap
     */
    public abstract void dispose(Object disposable);
}