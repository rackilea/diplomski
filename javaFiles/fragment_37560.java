object ProtoEnumWrapper {
  def fromString[T <: Enum[T] with ProtocolMessageEnum](s: String)(implicit ct: ClassTag[T]: ProtoEnumWrapper[T] = try {
    new ProtoEnumWrapper(Enum.valueOf[T](ct.runtimeClass, s))
  } catch {
    case e: IllegalArgumentException => throw new InvalidStringForEnum(s"${s} is not a value of ${ct.runtimeClass}")
  }

  def fromProto[T <: Enum[T] with ProtocolMessageEnum : ClassTag](proto: T): ProtoEnumWrapper[T] =
    new ProtoEnumWrapper[T](proto)

  class InvalidStringForEnum(message: String) extends RuntimeException(message)
}

class ProtoEnumWrapper[T <: Enum[T] with ProtocolMessageEnum : ClassTag](proto: T) {
  override def equals(o: Any) = o match {
    case x: ProtoEnumWrapper[T] => proto == x.proto
    case e: T => proto == e
    case s: String => toString == s
    case _ => false
  }

  override def toString = proto.toString
}