$sched = New-Object -Com "Schedule.Service"
$sched.connect()
$out = @()
$sched.GetFolder("\").GetTasks(0) | % {
    $xml = [xml]$_.xml
    $out += New-Object psobject -Property @{
        "Name" = $_.Name
        "Status" = switch($_.State) {0 {"Unknown"} 1 {"Disabled"} 2 {"Queued"} 3 {"Ready"} $ {"Running"}}
        "NextRunTime" = $_.NextRunTime
        "LastRunTime" = $_.LastRunTime
        "LastRunResult" = $_.LastTaskResult
        "Author" = $xml.Task.Principals.Principal.UserID
        "Created" = $xml.Task.RegistrationInfo.Date
    }
}
$out | fl Name, Status, NextRunTime, LastRunTime, LastRunResult, Author, Created