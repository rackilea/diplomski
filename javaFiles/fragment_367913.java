import org.joda.time.DateTime
import org.joda.time.Period

String getAge(birthday) {
    def period = new Period(birthday, new DateTime())

    int years = period.getYears()
    int months = period.getMonths()
    int weeks = period.getWeeks()
    int days = period.getDays()

    String age

    if (years > 0) {
        age = "${years} year(s) and ${months} month(s)"
    } else if (months > 0) {
        age = "${months} month(s)"
    } else if (weeks > 0) {
        age = "${weeks} week(s)"
    } else {
        age = "${days} day(s)"
    }

    return age
}