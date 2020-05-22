package test
import java.io.InputStream
import java.util.ArrayList
import scala.collection.JavaConversions._
import org.objectweb.asm.ClassReader
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LocalVariableNode
import org.objectweb.asm.tree.MethodNode

object Util {
  case class Param(paraName:String, paraType:Type)
  case class ScalaMethod(name:String, returnType:Type, params:List[Param])

  def main(args:Array[String]):Unit = {
    getMethods(scala.util.Random.getClass).foreach(printMethod _ )
    def printMethod(m:ScalaMethod) = {
      println (m.name+" => "+m.returnType.getClassName)
      m.params.foreach(p =>
        println (" "+ p.paraName+":"+p.paraType.getClassName))
    }
  }

  /**
   * extracts the names, parameter names and parameter types of all methods of c
   */
  def getMethods(c:Class[_]):List[ScalaMethod] = {
    val cl:ClassLoader = c.getClassLoader();
    val t:Type = Type.getType(c);
    val url:String = t.getInternalName() + ".class";
    val is:InputStream = cl.getResourceAsStream(url);
    if (is == null)
      throw new IllegalArgumentException("""The class loader cannot
                                         find the bytecode that defined the
                                         class (URL: " + url + ")""");
    val cn = new ClassNode();
    val cr = new ClassReader(is);
    cr.accept(cn, 0);
    is.close();
    val methods = cn.methods.asInstanceOf[java.util.List[MethodNode]];
    var mList:List[ScalaMethod] = Nil
    if (methods.size > 0) for (i <- 1 to methods.size) {
      val m:MethodNode = methods.get(i-1)
      val argTypes:Array[Type] = Type.getArgumentTypes(m.desc);
      val paraNames = new java.util.ArrayList[String](argTypes.length)
      val vars = m.localVariables.asInstanceOf[java.util.List[LocalVariableNode]];
      var pList:List[Param] = Nil
      if (argTypes.length > 0) for (i <- 0 to argTypes.length) {
          // The first local variable actually represents the "this" object
          paraNames.add(vars.get(i).name);
          pList = Param(paraNames.get(i-1), argTypes(i-1)) :: pList
      }
      mList = ScalaMethod(m.name, Type.getReturnType(m.desc), pList) :: mList
    }
    mList
  }
}