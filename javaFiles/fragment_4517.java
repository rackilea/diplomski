UPDATE [LOW_PRIORITY] [IGNORE] table_reference
    SET col_name1={expr1|DEFAULT} [, col_name2={expr2|DEFAULT}] ...
    [WHERE where_condition]
    [ORDER BY ...]
    [LIMIT row_count]

String insert = "UPDATE PPN_WORKFLOW SET P1_F_Date = ?, P1_Completed = ?,  
C2_S_Date = ? WHERE ERF_No = ?";