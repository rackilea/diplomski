create type ni_imsi_rowtype as object (dummy varchar2(1)) -- use your real table's columns/types
/

create package ni_imsi_pkg as
  procedure get_curx(p_buf dual%rowtype, p_cur out sys_refcursor);
  procedure get_curx_wrapper(p_buf ni_imsi_rowtype, p_cur out sys_refcursor);
end ni_imsi_pkg;
/

create package body ni_imsi_pkg as
  -- original procedure, simplified for demo
  procedure get_curx(p_buf dual%rowtype, p_cur out sys_refcursor) is
  begin
    open p_cur for select * from dual where dummy = p_buf.dummy;
  end;

  -- wrapper procedure taking new type instead of rowtype
  procedure get_curx_wrapper(p_buf ni_imsi_rowtype, p_cur out sys_refcursor) is
    l_buf dual%rowtype;
  begin
    l_buf.dummy := p_buf.dummy;
    get_curx(l_buf, p_cur);
  end;
end ni_imsi_pkg;
/