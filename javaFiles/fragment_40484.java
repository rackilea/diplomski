final Dialog mDialog = new Dialog(getActivity());
mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mDialog.setContentView(R.layout.grid_dialogue);
mDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);}
GridView mGridView = mDialog.findViewById(R.id.grid_dialog);
// your whole dialog code