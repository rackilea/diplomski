if(job_object.tasklist.get(position).task_status.equals("COMPLETED"))
    {
        holder.txttaskstatus.setText("DONE");
    }else{
        //I've added this else clause to your code.
        holder.txttaskstatus.setText("MyTextIfNotDone");
    }