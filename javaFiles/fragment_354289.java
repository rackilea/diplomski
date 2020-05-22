if ((what = recv(u_sock, buff, sizeof(buff)-1, 0)) < 0)
{
    ⋮
}
else
{
    buff[what] = 0;
    cout << buff << endl;
}