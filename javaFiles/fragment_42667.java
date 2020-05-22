while (!Que.isEmpty()) 
{
        Ttotal = Ttotal + disp;
        System.out.println(Que.peekFirst().getExecSize());
        Exec=Que.peekFirst().getExecSize();
        output += String.format("T%d: %s\n",Ttotal,Que.peekFirst().getID());
        Que.peekFirst().setTstart(Ttotal);
        Ttotal = Ttotal+Exec;
        Que.peekFirst().setTend(Ttotal);
        Quecleared.add(Que.pollFirst());
}