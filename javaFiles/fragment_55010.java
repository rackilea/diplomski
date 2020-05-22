@Override
public Fragment getItem(int position) {
    switch(position)
    {
        case 0: 
            return stopwatchFragment;
        case 1:                
            return countdownFragment;
        default:return null;
    }
}