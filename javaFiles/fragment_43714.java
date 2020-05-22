public interface MyClock {
    void setTime(int x, int y, int z);
    void incTimeBySec();
    void incTimeByMins(int x);
    void display12hr();
    void  display24hr();
}