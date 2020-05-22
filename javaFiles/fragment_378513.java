delimiter #

create procedure insert_tblm_tlmngorderinward
(
in p_itemcode varchar(80) -- p_ is for param
)
begin

-- v_ is for variable 

declare v_inwardstock, v_issuestock, v_updatestock decimal(15,0) default 0;

    -- do this in stored proc

    insert into tblm_tlmngorderinward (itemcode) values (p_itemcode);

    -- now do all the trigger stuff

    select sum(stock) into v_inwardstock from tblm_tlmngorderinward where itemcode = p_itemcode;
    select sum(stock) into v_issuestock from tblt_tlmngissueitem where itemcode = p_itemcode;

    if(v_inwardstock > 0) then
        set v_updatestock = v_inwardstock;      
    end if;

    if(v_issuestock > 0) then
        set v_updatestock = v_updatestock - v_issuestock;       
    end if;

    update tblm_tlmngitem set stock = v_updatestock where itemcode = p_itemcode;

end#

delimiter ;

call insert_tblm_tlmngorderinward('why_use_a_trigger');