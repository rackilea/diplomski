case class Op ( x: Int) {
  def +++(that: Op) = {
    println(this.x + " +++ " + that.x)
    Op(this.x+that.x)
  } 
  def ***(that: Op) = {
    println(this.x + " *** " + that.x)
    Op(this.x * that.x)
  }  
}