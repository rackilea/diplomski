<sftp:inbound-endpoint
    connector-ref="sftpServer"
    host="${sftp.host}"
    port="${sftp.port}"
    path="${sftp.path}"
    user="${sftp.user}"
    password="${sftp.password}"
    responseTimeout="${standard.response.timeout.millis}"
    sizeCheckWaitTime="${sftp.sizeCheckWaitTime.millis}"
    pollingFrequency="${sftp.polling.frequency.millis}"
    autoDelete="false"
    encoding="UTF-16LE"
    doc:name="SFTPEndpoint">
    <file:filename-wildcard-filter pattern="${sftp.filename}" />
</sftp:inbound-endpoint>

<scripting:transformer doc:name="Convert File Encoding">
  <scripting:script engine="Groovy" file="encodingConverter.groovy" />
</scripting:transformer>

<!-- Do flow stuff here -->