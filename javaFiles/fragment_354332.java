import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.Structure;

/** Simple example of JNA interface mapping and usage. */
public class HelloJNAWorld {

    // This is the standard, stable way of mapping, which supports extensive
    // customization and mapping of Java to native types.

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
        Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),CLibrary.class);


        void printf(String format, Object... args);


    }

    public interface IPCLibrary extends Library {
        IPCLibrary INSTANCE = (IPCLibrary)           
        Native.loadLibrary("c",IPCLibrary.class);



        class WaitQueue extends Structure{

        }


        // mapping msqid_ds structure
        class MsqidDs extends Structure{
            long msg_stime;       /* last msgsnd time */
            long msg_rtime;       /* last msgrcv time */
            long msg_ctime;       /* last change time */
            short msg_cbytes;
            short msg_qnum;
            short msg_qbytes;      /* max number of bytes on queue */
            short msg_lspid;       /* pid of last msgsnd */
            short msg_lrpid;       /* last receive pid */
        }

        // END mapping msqid_ds structure

        class MsgBuf extends Structure{
            NativeLong mtype; /* type of message */
            byte mtext[] = new byte[1];
        }


        class MyMsgBuf extends MsgBuf{
            public NativeLong messageKind;
            public byte[] contenido = new byte[1024];
        }

        // Initialize queue, or if it exists, get it            
        int msgget(NativeLong key, int msgflg);
        // Send messages to queue
        // int msgsnd(int msqid, struct msgbuf *ptrkey, int length, int flag);
        int msgsnd(int msqid, MsgBuf ptrkey, int msgsz, int msgflg);
        // Receive messages from queue
        // int msgrcv(int msqid, struct msgbuf *ptrkey, int length, long msgtype, int flag);
        int msgrcv(int msqid, MsgBuf ptrkey, int length, long msgtype, int flag);            

    }

    public static void main(String[] args) {

        int idCola = IPCLibrary.INSTANCE.msgget(new NativeLong(12500), 0);            

        if(idCola<0){
            System.out.println("The queue can't be created. IdCola:"+idCola);           
            System.out.println("Error msgget: " + Native.getLastError());
        }else{
            System.out.println("Queue with id:" + idCola + "has been recovered");           
            // Send message
            IPCLibrary.MyMsgBuf mensaje = new IPCLibrary.MyMsgBuf();
            mensaje.tipoMensaje = new NativeLong(1);
            mensaje.contenido = "Sending message".getBytes();
            int devSend = IPCLibrary.INSTANCE.msgsnd(idCola, mensaje, mensaje.contenido.length, 1);
            if(devSend != 0){
                System.out.println("Send response: "+devSend);
                System.out.println("Error value: " + Native.getLastError());
            }
        }

        // Receiving message
        IPCLibrary.MyMsgBuf mensajeRecibido =  new IPCLibrary.MyMsgBuf();        
        int bytesRecibidos = IPCLibrary.INSTANCE.msgrcv(idCola, mensajeRecibido, mensajeRecibido.contenido.length, 1234, 0);
        if(bytesRecibidos > 0){
            System.out.println("C message has been received: " + new String(mensajeRecibido.contenido));
        }else{
            System.out.println("msgrcv error: " + Native.getLastError());
        }


        // Send closing message
        IPCLibrary.MyMsgBuf mensajeCierre = new IPCLibrary.MyMsgBuf();
        mensajeCierre.tipoMensaje = new NativeLong(2);
        mensajeCierre.contenido = "Closing queue".getBytes();
        int devSend = IPCLibrary.INSTANCE.msgsnd(idCola, mensajeCierre, mensajeCierre.contenido.length, 1);
        if(devSend != 0){
            System.out.println("Send response: "+devSend);
            System.out.println("Error value: " + Native.getLastError());
        }            

    }
}