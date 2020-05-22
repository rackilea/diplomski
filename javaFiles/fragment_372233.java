public class PendingFragment extends Fragment {

String username;

public PendingFragment(){
    //Required empty constructor
}

public static PendingFragment newInstance(String username) {
    PendingFragment fragment = new PendingFragment();
    Bundle args = new Bundle();
    args.putString("USERNAME", username);
    fragment.setArguments(args);
    return fragment;
}
.....//Initialize username inside onCreateView like this:
//username = getArguments().getString("USERNAME");
......    
private void sendRequest(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PendingFragment.this.getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(PendingFragment.this.getActivity());
        queue.add(stringRequest);
    }