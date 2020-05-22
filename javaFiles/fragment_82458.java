from("jms:queue")
  .wireTap("direct:save-file")
  .process(since I have the content of the file in exchange so generating crc)
  .to(file system save the crc file)
  .to(Push file to the sftp server);

from("direct:save-file")
  .to(save the file)
  .to(Push file to the sftp server);