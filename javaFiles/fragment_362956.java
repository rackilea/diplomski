String[] shellcmd = {
  "/bin/sh",
  "-c",
  whatToRun
};

Process proc = rt.exec(shellcmd);