object App {
  case class EmployeeLevel(id: Long, name: String, parentId: Long,
    item: List[EmployeeLevel])

  val employeeList = List(
    EmployeeLevel(1L, "Manoj", 0L, Nil),
    EmployeeLevel(2L, "Sv", 1L, Nil),
    EmployeeLevel(3L, "Cp", 2L, Nil),
    EmployeeLevel(4L, "Manju", 3L, Nil),
    EmployeeLevel(5L, "foobar", 2L, Nil),
    EmployeeLevel(6L, "barfoo", 42L, Nil))

  def main(args : Array[String]) {
    val nestedEmployees = createNestedEmployeesList(employeeList)

    println(nestedEmployees)
  }

  def createNestedEmployeesList(employees: List[EmployeeLevel]): Iterable[EmployeeLevel] = {
    val children = employees.groupBy(_.parentId)

    val rootNodes = findRootNodes(employees)

    rootNodes.flatMap(createChildrenList(_, children))
  }

  def createChildrenList(id: Long, children: Map[Long, List[EmployeeLevel]]): List[EmployeeLevel] = {
    children.get(id) match {
      case Some(employees) => 
        employees.map(employee => employee.copy(item = createChildrenList(employee.id, children)))
      case None => Nil
    }
  }

  def findRootNodes(employees: List[EmployeeLevel]): Set[Long] = {
    val parentIds = employees.map(_.parentId).toSet
    val nodeIds = employees.map(_.id).toSet

    parentIds &~ nodeIds
  }
}