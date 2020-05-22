@Controller
public class WebSocketContoller{
    @SubscribeMapping("/product/changes/{productId}")
    public void productIdSubscription(@DestinationVariable Long productId) {
        //Manage your product id subscription list e.g.
    }
}