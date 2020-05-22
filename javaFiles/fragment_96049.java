scala> new java.util.HashMap[Long, Long]().get(1L)
res0: Long = 0

scala> :javap -prv -
Binary file res0 contains $line3.$read$$iw$$iw$
[snip]
        17: invokestatic  #30                 // Method scala/runtime/BoxesRunTime.boxToLong:(J)Ljava/lang/Long;
        20: invokevirtual #34                 // Method java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        23: invokestatic  #38                 // Method scala/runtime/BoxesRunTime.unboxToLong:(Ljava/lang/Object;)J