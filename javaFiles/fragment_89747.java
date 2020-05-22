create or REPLACE function can_delete_contract(id int) returns boolean AS $$
BEGIN

  delete from CUSTOMER_CONTRACT c
    where c.ID = 1;

  return true;
EXCEPTION
  WHEN FOREIGN_KEY_VIOLATION then
    return false;
END;
$$ LANGUAGE plpgsql;