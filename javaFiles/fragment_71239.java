import scala.swing._

type I = java.lang.Integer
type D = java.lang.Double

val data = Array[Array[Object]](
  Array("a", 4:I, 8.9:D),
  Array("b", 7:I, 2.3:D),
  Array("c", 1:I, 5.6:D)
)

val m = new javax.swing.table.DefaultTableModel(data, 
  Array[AnyRef]("string", "int", "double")) {

  override def getColumnClass(c: Int): Class[_] = data(0)(c).getClass
}

val tj = new javax.swing.JTable(m)  // !!!
tj.setAutoCreateRowSorter(true)
val t = Component.wrap(tj)          // !!!

new Frame {
  contents = new ScrollPane(t)
  pack().centerOnScreen()
  open()
}