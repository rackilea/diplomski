for (int idx = 0; idx < 4; idx =* 2)
{
    int[] tmp = {cc[idx], cc[idx + 1};
    tea.encrypt(tmp, key);
    cc[idx] = tmp[0];
    cc[idx + 1] = tmp[1];
}