recvrequest(...)
{
    volatile off_t bytes = 0;
    struct timeval start, stop;

    gettimeofday(&start, (struct timezone *)0);
    while ((c = read(fileno(din), buf, bufsize)) > 0) {
        if ((d = write(fileno(fout), buf, c)) != c)
            break;      
        bytes += c;
    }
    gettimeofday(&stop, (struct timezone *)0);
    ptransfer("received", bytes, &start, &stop); 
}

ptransfer(const char *direction, off_t bytes,
    const struct timeval *t0,
    const struct timeval *t1)
{
    struct timeval td;
    float s, bs;

    tvsub(&td, t1, t0);
    s = td.tv_sec + (td.tv_usec / 1000000.);
#define nz(x)   ((x) == 0 ? 1 : (x))
    bs = bytes / nz(s);
    printf("%jd bytes %s in %.2f secs (%.1f kB/s)\n",
        (intmax_t) bytes, direction, s, bs / 1024.0);
}