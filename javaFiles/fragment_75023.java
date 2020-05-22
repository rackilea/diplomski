public class RallyDevice 
{
    private int _sno;
    private Time _currentTime;
    private double _dist;
    private double _avgSpeed;
    private double _requiredTime;
    private Time _idealTime;
    public RallyDevice()
    {
    }

    public RallyDevice(int sno, Time currentTime, double dist,double avgspeed,double requiredtime,Time idealtime) 
    {
        this._sno = sno;
        this._currentTime = currentTime;
        this._dist = dist;
        this._avgSpeed = avgspeed;
        this._requiredTime = requiredtime;
        this._idealTime = idealtime;
    }

    public RallyDevice( Time currentTime, double dist,double avgspeed,double requiredtime,Time idealtime) 
    {
        this._currentTime = currentTime;
        this._dist = dist;
        this._avgSpeed = avgspeed;
        this._requiredTime = requiredtime;
        this._idealTime = idealtime;
    }
}