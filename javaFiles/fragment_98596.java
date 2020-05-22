import util.control.Breaks._
// for continue, write this somewhere in your program
val continue = new Breaks
/* use like */
Breaks.breakable {
  for (i <- 1 to 10)
  continue.breakable { if (i % 2 == 0) continue.break; println(i); if (i == 7) Breaks.break }
}


//source http://daily-scala.blogspot.com/2010/04/breaks.html