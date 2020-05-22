SELECT msgs.msg_submit_date MSG_DATE FROM messages msgs
WHERE TRUNC(msgs.msg_submit_date)
BETWEEN TO_DATE(:startDate,YYYY-MM-DD) AND TO_DATE(:endDate,YYYY-MM-DD);

ERROR at line 3:
ORA-00904: "DD": invalid identifier