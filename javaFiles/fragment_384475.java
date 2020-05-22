queries= new String [] {"SET @SYSTEM_ID = (SELECT `id` FROM `users_admin` WHERE `username`='"+model.getUserName()+"');",
                 "SET @TRANSACTION_ID = (select `user_data`.`transaction` from `user_data` where id= "+idText.getText()+");",
                 "SET @FREEZE_ID = NULL;",
                 // set payment id to 0 for now, update it in pay operation.
                 "SET @PAYMENT_ID = NULL;",
                 "CALL user_freeze_add(@SYSTEM_ID, @TRANSACTION_ID, '"+FreezeStartDate.getValue()+"', '"+FreezeStartDate.getValue().plusDays(Integer.parseInt(freezeAvailabletext.getText()))+"', @PAYMENT_ID, @FREEZE_ID);"
};

ResultSet rs= DatabaseHandler.getInstance().runMutltipleQueries(queries);