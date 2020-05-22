package alehro.tcp;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

import alehro.log.Logger;
import alehro.tcp.ChunkFileResourceThrift.Iface;
import alehro.tcp.ChunkFileResourceThrift.get_file_args;
import alehro.tcp.ChunkFileResourceThrift.get_file_result;

public class ChunkedFileResourceProcessor extends
    ChunkFileResourceThrift.Processor {

public interface IfaceExt extends Iface {
    void get_file_raw(String key, String file_name, TProtocol out)
            throws TException, ServerSideError;
}

final private IfaceExt iface_1;


public ChunkedFileResourceProcessor(IfaceExt iface) {
    super(iface);
    iface_1 = iface;
    // replace generated implementation by my custom one.
    processMap_.put("get_file", new get_file_raw());
}

private class get_file_raw implements ProcessFunction {

    @Override
    public void process(int seqid, TProtocol iprot, TProtocol oprot)
            throws TException {
        get_file_args args = new get_file_args();
        try {
            args.read(iprot);
        } catch (org.apache.thrift.protocol.TProtocolException e) {
            iprot.readMessageEnd();
            org.apache.thrift.TApplicationException x = new org.apache.thrift.TApplicationException(
                    org.apache.thrift.TApplicationException.PROTOCOL_ERROR,
                    e.getMessage());
            oprot.writeMessageBegin(new org.apache.thrift.protocol.TMessage(
                    "get_file",
                    org.apache.thrift.protocol.TMessageType.EXCEPTION,
                    seqid));
            x.write(oprot);
            oprot.writeMessageEnd();
            oprot.getTransport().flush();
            return;
        }
        iprot.readMessageEnd();
        get_file_result result = new get_file_result();
        try {
            iface_1.get_file_raw(args.key, args.file_name, oprot);
        } catch (ServerSideError ouch) {
            result.ouch = ouch;
        } catch (Throwable th) {
            Logger.me.e("Internal error processing get_file_raw");
            Logger.me.e(th.getMessage());
            Logger.me.e(th);
            org.apache.thrift.TApplicationException x = new org.apache.thrift.TApplicationException(
                    org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                    "Internal error processing get_file");
            oprot.writeMessageBegin(new org.apache.thrift.protocol.TMessage(
                    "get_file",
                    org.apache.thrift.protocol.TMessageType.EXCEPTION,
                    seqid));
            x.write(oprot);
            oprot.writeMessageEnd();
            oprot.getTransport().flush();
            return;
        }
        oprot.writeMessageBegin(new org.apache.thrift.protocol.TMessage(
                "get_file", org.apache.thrift.protocol.TMessageType.REPLY,
                seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
    }

}

}