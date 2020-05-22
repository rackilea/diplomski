select name, detected_usages, last_usage_date, last_sample_date
from dba_feature_usage_statistics
where name in (
    'ADDM', 'Automatic SQL Tuning Advisor', 'Automatic Workload Repository',
    'AWR Baseline', 'AWR Baseline Template', 'AWR Report', 'EM Performance Page',
    'Real-Time SQL Monitoring', 'SQL Access Advisor',
    'SQL Monitoring and Tuning pages', 'SQL Performance Analyzer',
    'SQL Tuning Advisor', 'SQL Tuning Set (system)', 'SQL Tuning Set (user)'
)
order by name;

NAME                            DETECTED_USAGES LAST_USAG LAST_SAMP
------------------------------- --------------- --------- ---------
ADDM                                          0           05-JAN-14
AWR Baseline                                  0           05-JAN-14
AWR Baseline Template                         0           05-JAN-14
AWR Report                                    0           05-JAN-14
Automatic SQL Tuning Advisor                 24 05-JAN-14 05-JAN-14
Automatic Workload Repository                 0           05-JAN-14
EM Performance Page                           0           05-JAN-14
Real-Time SQL Monitoring                     24 05-JAN-14 05-JAN-14
SQL Access Advisor                            0           05-JAN-14
SQL Monitoring and Tuning pages               0           05-JAN-14
SQL Performance Analyzer                      0           05-JAN-14
SQL Tuning Advisor                            0           05-JAN-14
SQL Tuning Set (system)                       0           05-JAN-14
SQL Tuning Set (user)                         0           05-JAN-14