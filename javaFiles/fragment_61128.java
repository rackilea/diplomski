AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
View viewInflated = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_people_info, (ViewGroup) mRootView, false);

ListView personListView = viewInflated.findViewById(R.id.people_listView);
ListAdapter listAdapter = new PersonAdapter(getActivity(), R.layout.person_lsit_item, personsInfo);
personListView.setAdapter(listAdapter);

builder.setView(viewInflated);
builder.setNegativeButton(R.string.action_close, (dialog, which) -> dialog.cancel());

AlertDialog dialog = builder.create();
dialog.show();