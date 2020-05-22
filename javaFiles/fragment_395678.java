//add the request to the queue
rq.add(request);

//initialize the progress dialog and show it
progressDialog = new ProgressDialog(getActivity());
progressDialog.setMessage("Fetching The File....");
progressDialog.show();