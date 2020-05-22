procedure image_post_handeler ( img varchar2) is 
    b blob;
begin
    b := HEXTORAW( UTL_URL.UNESCAPE(url('img')) );
    insert into image_table (id,  b) values (id_seq.nextval, b  );  
end;