function OnLoad() {
  if (document.referrer != "{identify your app here}")
    Session("BrowserWindowsOpen")++;
}

function OnUnLoad() {
  if ({your code for if window is closed})
  {
    Session("BrowserWindowsOpen")--;

    if (Session("BrowserWindowsOpen") == 0 )
      performLogOut();
  }
}