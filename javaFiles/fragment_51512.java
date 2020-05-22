import java.util
import java.util.concurrent.TimeUnit

import example.JAgeGroup
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import enumeratum._

object AgeGroupVanilla extends Enumeration {
  type AgeGroupVanilla = Value
  val Baby, Toddler, Teenager, Adult, Senior = Value
}

sealed trait AgeGroup extends EnumEntry

case object AgeGroup extends Enum[AgeGroup] {

  val values = findValues

  case object Baby     extends AgeGroup
  case object Toddler  extends AgeGroup
  case object Teenager extends AgeGroup
  case object Adult    extends AgeGroup
  case object Senior   extends AgeGroup

}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class So60374058 {
  private val jEnumEnumMap = {
    val m: util.EnumMap[JAgeGroup, String] = new util.EnumMap(classOf[JAgeGroup])
    JAgeGroup.values().foreach(e => m.put(e, e.name()))
    m
  }

  private val jEnumScalaMap = Map(JAgeGroup.values().map(e => e -> e.name()): _*)

  private val ageGroupScalaMap = Map(AgeGroup.values.map(e => e -> e.entryName): _*)

  private val vanillaScalaMap = AgeGroupVanilla.values.map(e => e -> e.toString).toMap

  private def randomFrom[A](seq: Seq[A]): A = {
    seq(scala.util.Random.nextInt(seq.size))
  }

  private var jEnum: JAgeGroup       = _
  private var ageGroupEnum: AgeGroup = _
  private var vanillaEnum: AgeGroupVanilla.AgeGroupVanilla = _

  @Setup(Level.Trial)
  def setup(): Unit = {
    jEnum = randomFrom(JAgeGroup.values())
    ageGroupEnum = randomFrom(AgeGroup.values)
    vanillaEnum = randomFrom(AgeGroupVanilla.values.toSeq)
  }

  @Benchmark
  def jEnumEnumMapGet(bh: Blackhole): Unit = bh.consume {
    jEnumEnumMap.get(jEnum)
  }

  @Benchmark
  def jEnumScalaMapGet(bh: Blackhole): Unit = bh.consume {
    jEnumScalaMap.get(jEnum)
  }

  @Benchmark
  def enumeratumScalaMapGet(bh: Blackhole): Unit = bh.consume {
    ageGroupScalaMap.get(ageGroupEnum)
  }

  @Benchmark
  def vanillaScalaMapGet(bh: Blackhole): Unit = bh.consume {
    vanillaScalaMap.get(vanillaEnum)
  }
}