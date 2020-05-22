import java.io._
import io.circe._
import io.circe.yaml._
import io.circe.parser._

def test(): Unit = {
  // test data instead of a file
  val ymlText =
    """
      |ALL:
      |  Category1:
      |    Subcategory11 : 1.5
      |    Subcategory12 : 0
      |    Subcategory13 : 0
      |    Subcategory14  : 0.5
      |  Category2:
      |    Subcategory21 : 1.5
      |    Subcategory22 : 0.3
      |    Subcategory23 : 0
      |    Subcategory24  : 0
    """.stripMargin


  var js = yaml.parser.parse(new StringReader(ymlText))
  var json: Json = js.right.get

  val categories = (json \\ "ALL").flatMap(j => j.asObject.get.values.toList)
  val subs = categories.flatMap(j => j.asObject.get.toList)
  val elements: List[(String, Double)] = subs.map { case (k, v) => (k, v.asNumber.get.toDouble) }
    .filter {
      case (k, v) => v > 0.0
    }
  println(s"elements: $elements")

  val allCategories = (json \\ "ALL").flatMap(j => j.asObject.get.toList).toMap
  val filteredTree: Map[String, Map[String, Double]] = allCategories
    .mapValues(catJson => catJson.asObject.get.toList.map { case (subName, subJson) => (subName, subJson.asNumber.get.toDouble) }
      .filter { case (subName, subValue) => subValue > 0.0 }
      .toMap)
  println(s"filteredTree : $filteredTree")
}