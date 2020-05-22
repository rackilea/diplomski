@Component("bar")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Bar extends Foo  {
@Overrride
public void setCalc(Integer calc){this.calc = calc*10)
}


@Component("bazz")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Bazz extends Foo  {
@Override
public void setCalc(Integer calc){this.calc = calc+10)