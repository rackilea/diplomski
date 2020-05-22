@Service
public class SecurityGroupServiceImpl implements SecurityGroupService {    
    @Autowired    
    AmazonEC2 ec2;

    @Override
    public DeleteSecurityGroupResult deleteSecurityGroup(SecurityGroupDTO securityGroupDTO) {

        DeleteSecurityGroupRequest request = new DeleteSecurityGroupRequest()
                .withGroupId(securityGroupDTO.getGroupID());

        DeleteSecurityGroupResult response = ec2.deleteSecurityGroup(request);
        System.out.println(response);
        return response;
    }
}