driver_mac80211_nl.c

int wpa_driver_nl80211_driver_cmd(void *priv, char *cmd, char *buf,
                  size_t buf_len )
{
    .
    .
    linux_get_ifhwaddr(drv->global->ioctl_sock, bss->ifname, macaddr);
    .
    .
}