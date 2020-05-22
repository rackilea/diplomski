package com.mahesh.dialect;
import org.hibernate.dialect.MySQLMyISAMDialect

class MySQL5MyISAMDialect extends MySQLMyISAMDialect {
   String getTableTypeString() {
      " ENGINE=MyISAM"
   }
}