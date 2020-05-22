....

@Override
public void onResponse(Call<OrderHistoryResponse> call, Response<OrderHistoryResponse> response) {
                Toast.makeText(OrderHistoryActivity.this, "" + response.body().getData(), Toast.LENGTH_SHORT).show();
     runOnUiThread(new Runnable() {
            @Override
            public void run() {
                OrderHistoryRecyclerAdapter adapter = new OrderHistoryRecyclerAdapter(response.body().getData());

      //This recyclerView object should create before,  like      findViewById(R.id.recyclerViewIdinXML)


         RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
        ((LinearLayoutManager) manager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
         recyclerView.setAdapter(adapter);


            }
        });
    }

   ...