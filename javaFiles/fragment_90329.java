import com.apple.foundationdb._
import com.apple.foundationdb.tuple._
import resource.managed

import scala.collection.mutable
import scala.util.Random

object Example {

  val THREAD_COUNT = 1

  @volatile var v0: Long = 0
  @volatile var v1: Long = 0
  @volatile var v2: Long = 0
  @volatile var v3: Long = 0
  @volatile var v4: Long = 0

  def doJob(db: Database, x: Int): Unit = {
    db.run((tr) => {
      val key = Tuple.from("OBJ", Long.box(100)).pack()

      val current = Tuple.fromBytes(tr.get(key).join())
      if (Random.nextInt(100) < 2) {
        out(current)
      }

      val next = mutable.ArrayBuffer(current.getLong(0), current.getLong(1), current.getLong(2), current.getLong(3), current.getLong(4))

      if (x == 1 && v1 == next(1)) { println(s"again: $v1, v0=$v0, 0=${next(0)}")}
      if (x == 0 && v0 > next(0)) { out(current); ??? } else { v0 = next(0)}
      if (x == 1 && v1 > next(1)) { out(current); ??? } else { v1 = next(1)}
      if (x == 2 && v2 > next(2)) { out(current); ??? } else { v2 = next(2)}
      if (x == 3 && v3 > next(3)) { out(current); ??? } else { v3 = next(3)}
      if (x == 4 && v4 > next(4)) { out(current); ??? } else { v4 = next(4)}

      next.update(x, next(x) + 1)
      val nv = Tuple.from(next.map(v => Long.box(v)) :_*)

      tr.set(key, nv.pack())
    })

  }

  def main(args: Array[String]): Unit = {
    if (THREAD_COUNT > 5) {
      throw new IllegalArgumentException("")
    }

    val fdb: FDB = FDB.selectAPIVersion(510)
    for (db <- managed(fdb.open())) {
      // Run an operation on the database
      db.run((tr) => {
        for (x <- 0 to 10000) {
          val k = Tuple.from(s"OBJ", x.toLong.underlying()).pack()
          val v = Tuple.from(Long.box(0), Long.box(0), Long.box(0), Long.box(0), Long.box(0)).pack()
          tr.set(k, v)
          null
        }
      })


      val threads = (0 to THREAD_COUNT).map { x =>
        new Thread(new Runnable {
          override def run(): Unit = {
            while (true) {
              try {
                doJob(db, x)
              } catch {
                case t: Throwable =>
                  t.printStackTrace()
              }
            }
          }
        })
      }

      threads.foreach(_.start())
      threads.foreach(_.join())


    }
  }

  private def out(current: Tuple) = {
    println("===")
    println((v0, v1, v2, v3, v4))
    println((Thread.currentThread().getId, current))
  }
}