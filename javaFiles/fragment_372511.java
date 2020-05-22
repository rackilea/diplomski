import com.google.gson._
import scala.reflect.ClassTag
import java.lang.reflect.Type

class ArrayBufferSerializer[T : ClassTag] extends JsonSerializer[ArrayBuffer[T]] {
    override def serialize(src: ArrayBuffer[T], typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
        context.serialize(src.toArray)
    }
}