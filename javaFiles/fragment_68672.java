import java.sql.Date
import java.time.LocalDate
// other imports

class SomeDbClass {
  implicit val localDateToDate = MappedColumnType.base[LocalDate, Date](
    l => Date.valueOf(l),
    d => d.toLocalDate
  )

  private[PositionTable] class PositionTable(tag: Tag) extends Table[Position](tag, "POSITIONS")  {
    val positionId = column[Int]("POSITION_ID", O.PrimaryKey, O.AutoInc)
    val companyName = column[String]("COMPANY_NAME")
    val title = column[String]("TITLE")
    val startDate = column[Option[LocalDate]]("START_DATE")
    val endDate = column[Option[LocalDate]]("END_DATE")
    def * = (companyName, title, startDate, endDate, positionId.?) <>(Position.tupled, Position.unapply)
  }
}