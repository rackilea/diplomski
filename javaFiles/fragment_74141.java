boolean bFile_can_be_opened = false;
while (!bFile_can_be_opened) {
  try {
    fwLog2 = new FileWriter(sLp_LogFile, true);
    bFile_can_be_opened = true;
  }
  catch (Exception e)
  {}
}