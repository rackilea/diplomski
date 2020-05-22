recylcerAdapter RecylcerAdapter =
        new recylcerAdapter(image.toArray(new  Integer[image.size()]), names.toArray(new String[names.size()]));
LinearLayoutManager manager = new LinearLayoutManager(getActivity());
manager.canScrollVertically();
recyclerView.setLayoutManager(manager);
recyclerView.setAdapter(RecylcerAdapter);

RecylcerAdapter.setListener(new recylcerAdapter.Listener() {
    public void onClick(int position) {
        vibrator.vibrate(50);

        Intent intent = new Intent(getActivity(), EquationsActivity.class);
        intent.putExtra(EquationsActivity.POSITION, position);
        getActivity().startActivity(intent);

    }
});