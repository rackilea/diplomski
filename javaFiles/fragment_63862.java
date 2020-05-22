begin
   if inserting then
      if :NEW."MY_ID" is null then
         select MY_SEQ.nextval into :NEW."MY_ID" from dual;
      end if;
   end if;
end;