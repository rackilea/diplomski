import java.io.RandomAccessFile;
import java.io.FileInputStream;
import java.io.DataInputStream;

import org.eclipse.jdt.internal.core.util.Disassembler;
import org.eclipse.jdt.core.util.ClassFormatException;

/**
 * ClassDump : show a classfile dump the same way as Eclipse
 */
class ClassDump {

    public static void main(String[] args){

        System.out.println("Class dumper");
        if(args.length != 1){
            System.out.println("Usage : Disasm <file.class>");
            System.exit(1);
        }

        new ClassDump(args[0]);
    }

    public ClassDump(String classfile){

        byte[] classbuf = readClassBytes(classfile);

        System.out.println(String.format("Class size = %d bytes", classbuf.length));

        Disassembler dis = new Disassembler();
        try {
            System.out.print(dis.disassemble(classbuf, "\n", org.eclipse.jdt.internal.core.util.Disassembler.DETAILED));
        } catch(ClassFormatException cfe){
            cfe.printStackTrace();
        }
    }

    private byte[] readClassBytes(String classfile){
        byte[] buf;

        try{
            RandomAccessFile raf = new RandomAccessFile(classfile,"r");
            FileInputStream fis = new FileInputStream(raf.getFD());
            DataInputStream dis = new DataInputStream(fis);

            buf =  new byte[(int)raf.length()];
            dis.readFully(buf);

            dis.close();
            fis.close();
            raf.close();

        } catch (Exception ex){
            ex.printStackTrace();
            return new byte[0];
        }           

        return buf;

    }
}