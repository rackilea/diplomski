BEGIN
DBMS_SCHEDULER.CREATE_PROGRAM (
program_name            => 'testjar',
program_type            => 'EXECUTABLE',
program_action          => 'C:\MYSTUFF\testjar.bat',
enabled                 => TRUE,
comments                => 'test testjar'
);
END;
/

begin  
dbms_scheduler.create_job  
 (job_name => 'testjar_job',  
  program_name=> 'testjar',    
  enabled=>true,  
  auto_drop=>false,  
  comments=>'Only run immediately by dbms_scheduler.run_job');  
end; 
/


begin  
    dbms_scheduler.run_job('testjar_job',TRUE);  
end;  
/