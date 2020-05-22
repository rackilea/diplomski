// PREPARE PARAMETERS
String[] params = new String[10];
params[0] = "1";
params[1] = "1";
params[2] = "abc";


// NEW ASYNC TASK 
new GetData_AsyncTask(getActivity(), params).execute();