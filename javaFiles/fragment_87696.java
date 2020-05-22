class PingInvoker {

    public PingInvoker() {
        // TODO Auto-generated constructor stub
        Timer timer = new Timer();
        timer.schedule(new Mytask(), 0, period);
    }

    public void ping() {
        List<Server> svr = Manager.getList();

        for (Server i : svr)
        i.ping();
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
          ping();
        }
    }