@Inject
private Instance<BeanA> beanA;

....

public void doStuff(Event e) {
   ...
   case Type.Production:
            //lazily evaluates and instantiatiates bean.
            beanA.get().evaluateResult(e);
}