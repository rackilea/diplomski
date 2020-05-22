package VirtualGuest;

import com.softlayer.api.ApiClient;
import com.softlayer.api.RestApiClient;
import com.softlayer.api.service.Location;
import com.softlayer.api.service.virtual.Guest;
import com.softlayer.api.service.virtual.guest.block.device.template.Group;

/**
 * Created by Ruber Cuellar on 5/3/2016.
 */
public class CreateObject {

    public CreateObject(){
        // Declare username and api key
        String username = "set me";
        String apiKey = "set me";
        // Get Api Client and service
        ApiClient client = new RestApiClient().withCredentials(username, apiKey);
        Guest.Service guestService = Guest.service(client);

        Guest guest = new Guest();
        guest.setHostname("rcvtest-3");
        guest.setDomain("softlayer.com");
        guest.setStartCpus(2L);
        guest.setHourlyBillingFlag(true);
        guest.setLocalDiskFlag(true);
        guest.setMaxMemory(1L);
        // Setting datacenter
        Location newLocation = new Location();
        newLocation.setName("sjc03");
        guest.setDatacenter(newLocation);
        // Setting image template
        Group blockDevice = new Group();
        blockDevice.setGlobalIdentifier("ce3f5ea3-893a-4992-ad14-5bcd99d9b32a");
        guest.setBlockDeviceTemplateGroup(blockDevice);

    try{
        Guest result = guestService.createObject(guest);
        System.out.println(result.getId());

    } catch (Exception e)
    {
        System.out.println("Error: " + e);
    }
}
    public static void main(String [] args)
    {
        new CreateObject();
    }
}