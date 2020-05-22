SQL>select username,osuser,program,machine
from v$session
where username = 'ROB'; 

USERNAME  OSUSER       PROGRAM             MACHINE
--------- -----------  ------------------  -----------
ROB       rmerkw       My Program Name     machine