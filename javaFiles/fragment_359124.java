BEGIN
  dbms_scheduler.create_job(job_name => '"HR"."RUN_PROC_DO_NOTHING"',schedule_name => '"YOUR_SCHEDULER_WINDOW_HERE"',job_type => 'STORED_PROCEDURE'
    ,job_action => 'HR.DO_NOTHING_COMMENTS',number_of_arguments => 2,enabled => false,auto_drop => false,comments => 'will run procedure do_nothing_comments'
    );

  dbms_scheduler.set_job_argument_value(job_name => '"HR"."RUN_PROC_DO_NOTHING"',argument_position => 1,argument_value => '1');

  dbms_scheduler.set_job_argument_value(job_name => '"HR"."RUN_PROC_DO_NOTHING"',argument_position => 2,argument_value => '2');

  dbms_scheduler.set_attribute(name => '"HR"."RUN_PROC_DO_NOTHING"',attribute => 'store_output',value => true);

  dbms_scheduler.set_attribute(name => '"HR"."RUN_PROC_DO_NOTHING"',attribute => 'logging_level',value => dbms_scheduler.logging_off);

  dbms_scheduler.enable(name => '"HR"."RUN_PROC_DO_NOTHING"');
END;