private Handler handler = new Handler();
private TaskCanceler taskCanceler;
...
LoadData task = new LoadData();
taskCanceler = new TaskCanceler(task);
handler.postDelayed(taskCanceler, 20*1000);
task.execute(...)