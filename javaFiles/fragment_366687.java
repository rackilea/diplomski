import com.sun.jna.Library
import com.sun.jna.WString
import com.sun.jna.Native

trait Services extends Library {

  def ReverseStringWrapper(m:WString) : Boolean

}

object JNA {
  def main(args:Array[String]):Unit = {
    println("Testin JNA!! ")
    val librarypath = "./lib"
    System.setProperty("jna.library.path", librarypath)
    val libc = Native.load("Services", classOf[Services])
    val x=libc.ReverseStringWrapper(new WString("dddd"))
    println("Result: " + x);
  }
}