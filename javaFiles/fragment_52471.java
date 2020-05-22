import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceSpecification;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.services.ec2.model.RequestSpotInstancesRequest;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.services.ec2.model.Tag;

public class SpotLauncher
{
  private static final int kInstances = 25;
  private static final String kMaxPrice = "0.007";
  private static final InstanceType kInstanceType = InstanceType.M3Medium;

  private static final String kSubnet = "subnet-xxxx";
  private static final String kAmi = "ami-xxxx";

  private static final String kName = "spot";
  private static final String kSecurityGroup2 = "sg-xxxx";
  private static final String kSecurityGroup1 = "sg-yyyy";

  public static void main(String[] args)
  {
    AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

    RequestSpotInstancesRequest request = new RequestSpotInstancesRequest();

    request.setSpotPrice(kMaxPrice); // max price we're willing to pay
    request.setInstanceCount(kInstances);

    LaunchSpecification launchSpecification = new LaunchSpecification();
    launchSpecification.setImageId(kAmi);
    launchSpecification.setInstanceType(kInstanceType);
    launchSpecification.setKeyName("aws");

    // security group IDs - don't add them, they're already added to the network spec
    // launchSpecification.withAllSecurityGroups(new GroupIdentifier().withGroupId("sg-xxxx"), new GroupIdentifier().withGroupId("sg-yyyy"));

    List<String> securityGroups = new ArrayList<String>();
    securityGroups.add(kSecurityGroup1);
    securityGroups.add(kSecurityGroup2);

    InstanceNetworkInterfaceSpecification networkSpec = new InstanceNetworkInterfaceSpecification();
    networkSpec.setDeviceIndex(0);
    networkSpec.setSubnetId(kSubnet);
    networkSpec.setGroups(securityGroups);
    networkSpec.setAssociatePublicIpAddress(true);

    List<InstanceNetworkInterfaceSpecification> nicWrapper = new ArrayList<InstanceNetworkInterfaceSpecification>();
    nicWrapper.add(networkSpec);

    // launchSpecification.setSubnetId("subnet-ccde4ce1"); // don't add this, it's already added to the network interface spec
    launchSpecification.setNetworkInterfaces(nicWrapper);

    // add the launch specifications to the request
    request.setLaunchSpecification(launchSpecification);

    // call the RequestSpotInstance API
    ec2.requestSpotInstances(request);

    while (!SetEc2Names(ec2))
    {
      Sleep(2000);
    }

    System.out.println("\nDONE.");

  }

  private static void Sleep(long aMillis)
  {
    try
    {
      Thread.sleep(aMillis);
    }
    catch (InterruptedException aEx)
    {
      aEx.printStackTrace();
    }
  }

  private static boolean SetEc2Names(AmazonEC2 aEc2Client)
  {
    List<SpotInstanceRequest> requests = aEc2Client.describeSpotInstanceRequests().getSpotInstanceRequests();

    Collections.sort(requests, GetCreatedDescComparator());

    for (int i = 0; i < kInstances; i++)
    {
      SpotInstanceRequest request = requests.get(i);
      if (request.getLaunchSpecification().getImageId().equals(kAmi))
      {
        System.out.println("request: " + request);

        String instanceId = request.getInstanceId();

        if (instanceId == null)
        {
          System.out.println("instance not launched yet, we don't have an id");
          return false;
        }

        System.out.println("setting name for newly launched spot instance, id: " + instanceId);

        AssignName(aEc2Client, request);
      }
    }

    return true;
  }

  private static void AssignName(AmazonEC2 aEc2Client, SpotInstanceRequest aRequest)
  {
    String instanceId = aRequest.getInstanceId();
    Tag tag = new Tag("Name", kName);

    CreateTagsRequest tagRequest = new CreateTagsRequest();

    List<String> instanceIds = new ArrayList<String>();
    instanceIds.add(instanceId);

    tagRequest.withResources(instanceIds);
    List<Tag> tags = new ArrayList<Tag>();
    tags.add(tag);
    tagRequest.setTags(tags);

    aEc2Client.createTags(tagRequest);
  }

  private static Comparator<SpotInstanceRequest> GetCreatedDescComparator()
  {
    return new Comparator<SpotInstanceRequest>()
    {

      @Override
      public int compare(SpotInstanceRequest o1, SpotInstanceRequest o2)
      {
        return -1 * o1.getCreateTime().compareTo(o2.getCreateTime());
      }

    };
  }

}