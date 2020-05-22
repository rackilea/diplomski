trait Form
trait SimpleForm extends Form
trait ComplexForm extends Form
trait ListForm[+T <: Form] extends ComplexForm {
   def l: List[T]
}


case class SimpleList(val l: List[SimpleForm]) extends SimpleForm with ListForm[SimpleForm]
case class ComplexList(val l: List[ComplexForm]) extends ListForm[ComplexForm]