procedure tester is

    LL : sorted_list.List;

begin
    sorted_list.Insert(LL, 5);
    declare
        larray : sorted_list.ListArray(1..sorted_list.length(LL));
    begin
        larray := sorted_list.toArray(LL);
        -- code that uses larray must be in this block
    end;
end;