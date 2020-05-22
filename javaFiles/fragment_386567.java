import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._
import java.nio.charset.StandardCharsets.UTF_8
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._
import scala.reflect.io.Streamable
import scala.util.hashing.MurmurHash3

case class Payload private(bs: Array[Byte]) {
  def this(s: String) = this(s.getBytes(UTF_8))

  override lazy val hashCode: Int = MurmurHash3.arrayHash(bs)

  override def equals(obj: Any): Boolean = obj match {
    case that: Payload => java.util.Arrays.equals(bs, that.bs)
    case _ => false
  }

  override def toString: String = new String(bs, UTF_8)
}

object Payload {
  def apply(s: String) = new Payload(s.getBytes)

  implicit val codec: JsonValueCodec[Payload] = new JsonValueCodec[Payload] {
    override def decodeValue(in: JsonReader, default: Payload): Payload = new Payload(in.readRawValAsBytes())

    override def encodeValue(x: Payload, out: JsonWriter): Unit = out.writeRawVal(x.bs)

    override val nullValue: Payload = new Payload(new Array[Byte](0))
  }
}

case class MessageWithPayload(payload: Payload)

object MessageWithPayload {
  implicit val codec: JsonValueCodec[MessageWithPayload] = JsonCodecMaker.make(CodecMakerConfig())

  val jsonBytes: Array[Byte] = Streamable.bytes(getClass.getResourceAsStream("debezium.json"))
}

@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgs = Array(
"-server",
"-Xms2g",
"-Xmx2g",
"-XX:NewSize=1g",
"-XX:MaxNewSize=1g",
"-XX:InitialCodeCacheSize=512m",
"-XX:ReservedCodeCacheSize=512m",
"-XX:+UseParallelGC",
"-XX:-UseBiasedLocking",
"-XX:+AlwaysPreTouch"
))
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.SECONDS)
class ExtractPayloadReading {
  @Benchmark
  def jsoniterScala(): MessageWithPayload = readFromArray[MessageWithPayload](MessageWithPayload.jsonBytes)
}