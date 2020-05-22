procedure tester is

    LL : sorted_list.List;

begin
    sorted_list.Insert(LL, 5);
    declare
        larray : sorted_list.ListArray := sorted_list.toArray(LL);
            -- no need to specify the bounds, it will take them from the bounds
            -- of the result returned by toArray
    begin
        -- code that uses larray must be in this block
    end;
end;