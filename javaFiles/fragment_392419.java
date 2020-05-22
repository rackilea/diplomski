function get_platform(os_name) {
  var os_str = os_name;
  var chk_win = os_str.substr(0, 3);
  var platform = "";
  if (chk_win == "Win")
    platform = "win";
  if (chk_win == "Lin")
    platform = "linux";
  if (chk_win == "X11")
    platform = "unix";
  return platform
};