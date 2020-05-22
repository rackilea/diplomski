scala> val stringSize: Any => Int = (_: String).size
<console>:11: error: type mismatch;
 found   : String => Int
 required: Any => Int
       val stringSize: Any => Int = (_: String).size
                                                ^