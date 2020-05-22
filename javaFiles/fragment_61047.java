trait AllowableBoxData  
object AllowableBoxData {
private of[T](cbd: ChooseBoxData[T]) = new ChooseBoxData(cbd.index, cbd.text) 
    with AllowableBoxData
  implicit def ofInt(cbd: ChooseBoxData[Int]) = of(cbd)
  implicit def ofString(cbd: ChooseBoxData[String]) = of(cbd)
}