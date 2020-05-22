final Dialog dialog = new Dialog(getApplicationContext(), R.style.FullHeightDialog);

    dialog.setContentView(R.layout.reclycer_data);
    dialog.setCancelable(false);

    if (dialog.getWindow() != null){
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    RecyclerView list = dialog.findViewById(R.id.recView);
    list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    list.setAdapter(adapter);

dialog.show();