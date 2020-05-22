class Soldier extends Thread {

    private Leader leader;

    public Soldier(Leader leader) {
        this.leader = leader;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                synchronized(leader)
                {

                    if(table.getResources()==this.need_Value)    //checking value of resource
                    {
                        sleep(1000);
                        table.clearResources();      //this will put the value of resource to 0
                        leader. notifyAll();
                    }
                }
            } catch(InterruptedException e) { }
        }
    }
}