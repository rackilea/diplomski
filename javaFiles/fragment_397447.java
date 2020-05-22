package getObserver;

import java.io.IOException;
import java.util.List;
import java.util.NavigableSet;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;

public class Observer extends BaseRegionObserver{

    private boolean isOewc;

    @Override
    public void preGetOp(ObserverContext<RegionCoprocessorEnvironment> arg0,
            Get arg1, List<Cell> arg2) throws IOException {
        NavigableSet<byte[]> qset = arg1.getFamilyMap().get("colfam1".getBytes());
        if(qset==null){//do nothing

        }else{

            String message = "qset.size() = "+String.valueOf(qset.size());
            String m = "isOewc = "+String.valueOf(isOewc);
            this.isOewc = true;
            Cell cell = CellUtil.createCell(
                    "preGet Row".getBytes(), 
                    m.getBytes(), 
                    message.getBytes(), 
                    System.currentTimeMillis(), 
                    KeyValue.Type.Put.getCode(), 
                    "preGet Value".getBytes());
            arg2.add(cell);
        }
    }

    @Override
    public void postGetOp(ObserverContext<RegionCoprocessorEnvironment> arg0,
            Get arg1, List<Cell> arg2) throws IOException {
        String m = "isOewc = "+String.valueOf(isOewc);
        Cell cell = CellUtil.createCell(
                "postGet Row".getBytes(), 
                m.getBytes(), 
                "postGet Qualifier".getBytes(), 
                System.currentTimeMillis(), 
                KeyValue.Type.Put.getCode(), 
                "postGet Value".getBytes());
        arg2.add(cell);
    }
}