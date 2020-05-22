<?php
  if( $_GET["jobId"] || $_GET["jobStatus"] )
  {
     echo "Job Id ". $_GET['jobId']. "<br />";
     echo "Job Status ". $_GET['jobStatus']. "";
  }
  $jobId=$_GET["jobId"];
  $jobStatus=$_GET["jobStatus"];
  $displayName=$_GET["displayName"];
  $name=$_GET["name"];
  $description=$_GET["description"];
  $frequency=$_GET["frequestuency"];
  $lastModifiedAt=$_GET["lastModifiedAt"];
  $createdAt=$_GET["createdAt"];    
  $createdBy=$_GET["createdBy"];        
  $opPath=$_GET["opPath"];      
  $env=$_GET["env"];
  $file = fopen("log.txt","w");
  echo fwrite($file,"Job ID : ".$jobId."\n"."Job Status : ".$jobStatus."\n"."Display Name : ".$displayName."\n"."Name : "."\n"."Description : ".$description."\n"."Frequency : ".$frequency."\n"."Last Modified At".$lastModifiedAt."\n"."Created At".$createdAt."\n"."Created By : ".$createdBy);
  fclose($file);
  chmod("log.txt", 0777);
  $last_line = system('/usr/local/hadoop/bin/hadoop fs -put /var/www/html/log.txt /user/hduser/Alert/', $retval);
  $last_line = system('/usr/local/hadoop/bin/hadoop fs -ls /user/hduser/Alert/', $retval);
  echo '<pre>';
  $output2 = exec('hadoop fs -copyFromLocal /var/www/html/log.txt /user/hduser/Alert/Notify');
  echo '
    </pre>
    <hr />' . $last_line . '
    <hr />' . $retval;
        '<hr />' . $output1;

?>