int counter = 0;
public void main1()
{
    counter += 1;
    if ( counter < 5 )
        this.main1();
}