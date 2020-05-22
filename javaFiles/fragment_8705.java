@Override
public void onActivityResult(int requestCode, int resultCode, Intent data)
{
// would use REQUEST CODE sent earlier if more than one activity sends back intents here
    if (resultCode == RESULT_OK)
    {
        counter = data.getInteExtra("counter", 0);  // get updated counter variable
    }
}