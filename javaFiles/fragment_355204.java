String addConstraint = "alter table ContactTable "+
"ADD CONSTRAINT FK_ContactTable_UserInfoTable "+
"FOREIGN KEY(UserInfoID) "+
"REFERENCES UserInfoTable (UserInfoID) "+
"ON UPDATE CASCADE "+
"ON DELETE CASCADE";