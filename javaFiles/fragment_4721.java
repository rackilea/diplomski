scala> import org.joda.time.{DateTime, Period}
import org.joda.time.{DateTime, Period}

scala> def dateRange(from: DateTime, to: DateTime, step: Period): Iterator[DateTime]      =Iterator.iterate(from)(_.plus(step)).takeWhile(!_.isAfter(to))
dateRange: (from: org.joda.time.DateTime, to: org.joda.time.DateTime, step: org.joda.time.Period)Iterator[org.joda.time.DateTime]

scala> val from = new DateTime().withYear(2012).withMonthOfYear(6).withDayOfMonth(30).minusYears(5)
from: org.joda.time.DateTime = 2007-06-30T21:46:05.536-07:00

scala> val to = new DateTime().withYear(2000).withMonthOfYear(6).withDayOfMonth(30)
to: org.joda.time.DateTime = 2000-06-30T21:46:26.186-07:00

scala> val range = dateRange(from, to, new Period().withMonths(6))
range: Iterator[org.joda.time.DateTime] = non-empty iterator

scala> range.toList
res4: List[org.joda.time.DateTime] = List(
2000-06-30T21:46:26.186-07:00,
2000-12-30T21:46:26.186-08:00,
2001-06-30T21:46:26.186-07:00,
2001-12-30T21:46:26.186-08:00,
2002-06-30T21:46:26.186-07:00,
2002-12-30T21:46:26.186-08:00,
2003-06-30T21:46:26.186-07:00,
2003-12-30T21:46:26.186-08:00,
2004-06-30T21:46:26.186-07:00,
2004-12-30T21:46:26.186-08:00,
2005-06-30T21:46:26.186-07:00,
2005-12-30T21:46:26.186-08:00,
2006-06-30T21:46:26.186-07:00,
2006-12-30T21:46:26.186-08:00)