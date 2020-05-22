<%
  new Thread(new Runnable() {
    public void run() {
      do_something_heavy();
    }
  }).start();
%>