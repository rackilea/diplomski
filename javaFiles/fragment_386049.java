import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.ConstantMethodref;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.LocalVariableTable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.NEW;

class javap
{
    public static void main(String[]args)
    {
        try
        {
            JavaClass jc = Repository.lookupClass("Test");
            ConstantPool constantPool = jc.getConstantPool();
            Method [] method=jc.getMethods();
            for (Method m : method) 
            {
                LocalVariableTable lvt=m.getLocalVariableTable();
                LocalVariable[] lv=lvt.getLocalVariableTable();
                for(LocalVariable l : lv)
                {   
                    System.out.println(l.getName()+" : "+l.getSignature());
                }
            }
            ConstantPoolGen cpg = new ConstantPoolGen(constantPool);
            for(Method m : method)
            {
                MethodGen mg = new MethodGen(m, m.getName(), cpg);
                for(InstructionHandle ih = mg.getInstructionList().getStart(); 
                        ih != null; ih = ih.getNext())
                {
                    if(ih.getInstruction() instanceof NEW) 
                    {
                        NEW newInst = ((NEW)ih.getInstruction());
                        String className = constantPool.getConstantString(
                            newInst.getIndex(), Constants.CONSTANT_Class);
                        System.out.println("Class instantiation: "+className);
                    }
                    if(ih.getInstruction() instanceof INVOKESTATIC) 
                    {
                        INVOKESTATIC newInst = ((INVOKESTATIC)ih.getInstruction());
                        String className = constantPool.getConstantString(
                                ((ConstantMethodref) constantPool
                                        .getConstant(newInst.getIndex()))
                                        .getClassIndex(),
                                Constants.CONSTANT_Class);
                        System.out.println("Static call: "+className);
                    }
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}