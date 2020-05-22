void run()
{
   // do stuff

   synchronized(this)
   {
      this.notify();
   }
}