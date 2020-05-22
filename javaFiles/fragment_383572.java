long skip=0;
if(mode==RESUME || mode==APPEND){
    try{
      SftpATTRS attr=_stat(dstb);
      skip=attr.getSize();
    }
    catch(Exception eee){
    }
}
if(mode==RESUME && skip>0){
    long skipped=src.skip(skip);
    if(skipped<skip){
      throw new SftpException(SSH_FX_FAILURE, "failed to resume for "+dst);
    }
}