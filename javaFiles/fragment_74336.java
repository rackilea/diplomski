int lastPos = 0;
public void addSubscriptionYear(int year, double subscription)
{
    subscriptions[lastPos]= new SubscriptionYear(year, subscription);
    lastPos++;
}