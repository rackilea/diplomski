// some pretend data
val origCSV = Seq("a,b,c", "d,e,f", "x,y,z")
val newCLMN = Seq("4X", "2W", "9A")

// put them together
val allData = origCSV.zip(newCLMN).map{case (a,b) => s"$a,$b\n"}