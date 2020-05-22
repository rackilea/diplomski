public class MainController
{
    private final AtomicLong counter;
    private final HashMap<Long, CallResult> callResults;

    public MainController(){
        counter = new AtomicLong();
        callResults  = new HashMap<>();
    }

public Login getLoginByUsername(String username)
    {
        long callID = counter.incrementAndGet();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ServerConnection.get("person-login-relations?byUsername="+username,null, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                        try {
                            callResults.put(callID, new CallResult(Login.parseFromJson(response)));
                            System.out.println(callResults.get(callID));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        })   .start();

        while(callResults.get(callID) == null){
            //wait
        }
        return (Login) callResults.remove(callID).content;
    }
}