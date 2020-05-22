Exec(
  'cmd.exe',
  '/k "' + AddQuotes(ExpandConstant('{app}\jre\bin\java.exe')) +
    ' -cp ' + AddQuotes(ExpandConstant('{app}\Application Lite.exe')) +
    ' com.examplesoftware.applicationlite.support.hibernateSupport"',
  '', SW_SHOW, ewWaitUntilTerminated, ResultCode);