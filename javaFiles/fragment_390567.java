class Vector3DBeanDefinitionParser extends AbstractSingleBeanDefinitionParser
{
  override def getBeanClass(element : Element) = classOf[Vector3DFactoryBean]

  override def doParse(element: Element, builder: BeanDefinitionBuilder)
  {
    val delim = element.getAttribute("delimeter")
    val value = element.getAttribute("value")

    builder.addPropertyValue("delimiter", delim)
    builder.addPropertyValue("value", value)
  }
}