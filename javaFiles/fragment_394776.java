import com.netapp.nmsdk.client.ApiRunner;
import com.netapp.nmsdk.client.ApiTarget;
import com.netapp.nmsdk.client.ApiTarget.TargetType;
import com.netapp.nmsdk.ontap.api.volume.VolumeInfo;
import com.netapp.nmsdk.ontap.api.volume.VolumeListInfoIterStartRequest;
import com.netapp.nmsdk.ontap.api.volume.VolumeListInfoIterStartRequest;
import java.util.Iterator;
import java.util.List;

public class VolList {

    public static void main(String[] args) { 


        try {
            ApiRunner runner = new ApiRunner(ApiTarget.builder()
                .withHost("your ip")
                .withUserName("your_username")
                .withPassword("your_password")
                .withTargetType(TargetType.FILER)
                .useHttp()
                .build());

            VolumeListInfoIterStartRequest volListReq = new VolumeListInfoIterStartRequest();

            Iterator<VolumeInfo> volumeIter = runner.iterate(volListReq, 10);

            VolumeInfo volume;

            while(volumeIter.hasNext()) {
                System.out.println("------------------------------------------------");
                volume = volumeIter.next();
                System.out.println("Name               : " + volume.getName()); 
                System.out.println("Type               : " + volume.getType()); 
                System.out.println("State              : " + volume.getState());
                System.out.println("Total size (bytes) : " + volume.getSizeTotal());
                System.out.println("Used size (bytes)  : " + volume.getSizeUsed());
                System.out.println("------------------------------------------------");
            }

            /// For getting aggr information ////////////////
            String aggrInfo = null;
    AggrListInfoRequest aggrListInfo = new AggrListInfoRequest();
    AggrListInfoResponse aggrlistResp = apirunner.run(aggrListInfo);
    JSONArray aggr_array = new JSONArray();
    for (AggrInfo aggr : aggrlistResp.getAggregates()) {

                System.out.println("Name"+aggr.getName());
                System.out.println("Name"+aggr.getBlockType());
                System.out.println("Name"+aggr.getOwnerName());
           }
         //////// End of aggregate information /////////////

       ///// Disk information //////////
       DiskListInfoRequest diskDetailReq = new DiskListInfoRequest();
    DiskListInfoResponse diskListInfoResp = apirunner.run(diskDetailReq);
    String diskInfo = null;
    JSONArray disk_array = new JSONArray();
    for (DiskDetailInfo disk : diskListInfoResp.getDiskDetails()) {
              System.out.println("Name"+disk.getName());
              System.out.println("vendor "+disk.getVendorId());
              System.out.println("Type"+ disk.getDiskType());
            }

       ////// End of disk information ////////
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}