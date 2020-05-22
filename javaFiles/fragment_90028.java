if( getActivity() != null ){
getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject json = (JSONObject) args[0];
                    String msg;

                    try {
                        msg = json.getString("message").toString();
                        ChatModel model = new ChatModel();
                        model.setMsg(msg);
                        items.add(model);
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
}