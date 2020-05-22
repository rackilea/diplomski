//i was initialized: i=0;
public void run()
{
    while(i<1)
    {
        final Customer customer = new Customer(till_set);
        customer.start();
        i++;
    }
}