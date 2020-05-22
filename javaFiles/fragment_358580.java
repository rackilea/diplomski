/*
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancingClientBuilder;
import com.amazonaws.services.elasticloadbalancingv2.model.DescribeLoadBalancersRequest;
import com.amazonaws.services.elasticloadbalancingv2.model.DescribeLoadBalancersResult;
*/
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClientBuilder;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import org.junit.Test;

public class AwsTestIT
{
    /*
    @Test
    public void testGetLoadBalancers()
    {
        AmazonElasticLoadBalancing amazonElasticLoadBalancingClient = AmazonElasticLoadBalancingClientBuilder
            .defaultClient();
        DescribeLoadBalancersResult result =
            amazonElasticLoadBalancingClient.describeLoadBalancers(new DescribeLoadBalancersRequest());
        result.getLoadBalancers().stream().forEach(loadBalancer -> System.out
            .println("loadBalancer = " + loadBalancer));
    }
    */

    @Test
    public void testGetLoadBalancers()
    {
        AmazonElasticLoadBalancing amazonElasticLoadBalancingClient = AmazonElasticLoadBalancingClientBuilder
            .defaultClient();
        DescribeLoadBalancersResult result =
            amazonElasticLoadBalancingClient.describeLoadBalancers(new DescribeLoadBalancersRequest());
        result.getLoadBalancerDescriptions().stream().forEach(loadBalancer -> System.out
            .println("loadBalancer = " + loadBalancer));
    }
}