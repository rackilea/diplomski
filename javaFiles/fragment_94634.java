SELECT APFileHeaderEO.ACTIVE,     
       APFileHeaderEO.CUSTOM_HEADER,     
       APFileHeaderEO.ENT_BY,     
       APFileHeaderEO.ENT_DATE,     
       APFileHeaderEO.FEEDER_ID,     
       APFileHeaderEO.FILE_HEADER_ID,     
       APFileHeaderEO.FILE_NAME,     
       APFileHeaderEO.MODIFY_BY,     
       APFileHeaderEO.MODIFY_DATE,     
       APFileHeaderEO.NEW_FILE_NAME,     
       APFileHeaderEO.SOURCE_SYSTEM,     
       APFileHeaderEO.STATUS,     
       APFileHeaderEO.TOTAL_RECORD_COUNTS,     
       APFileHeaderEO.COMMENTS,     
       APFileHeaderEO.CONTROL_TOTAL,     
       APFileHeaderEO.ACCOUNTING_DATE,     
       APFileHeaderEO.GENERIC_HEADER_ID,     
       APFileHeaderEO.GL_DATE,     
       APFileHeaderEO.GROSS_TOTAL_AMOUNT,     
       APFileHeaderEO.INSTANCE_ID,     
       APFileHeaderEO.INVOICE_RECEIVED_DATE,     
       APFileHeaderEO.NET_TOTAL_AMOUNT,     
       APFileHeaderEO.NUMBEROFINVOICES,     
       APFileHeaderEO.SOURCE,     
       APFileHeaderEO.SOURCE_FILE_PRODUCE_DATE,     
       APFileHeaderEO.VAT_TOTAL_AMOUNT,     
       APFileHeaderEO.SOURCE_FILE_NAME    
FROM  EI_AP_FILE_HEADER APFileHeaderEO where APFileHeaderEO.source in (select trim('''' from regexp_substr(:source1,'[^,]+', 1, level))     
from dual     
connect by     
regexp_substr(:source1, '[^,]+', 1, level)
is not null);