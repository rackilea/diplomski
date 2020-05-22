create function search_my_page(p_created_after in date, p_created_before in date)
return cursortype
    is rtn_cursor cursortype; 
begin
    open rtn_cursor for
    select news_id  
    from news
    where created between
        nvl(v_created_after, date '1234-01-01')
        and
        nvl(v_created_before, sysdate) + interval '1' day - interval '1' second;

    return rtn_cursor;
end search_my_page;
/