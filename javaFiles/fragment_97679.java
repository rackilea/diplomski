CREATE OR REPLACE FUNCTION update_order_price() RETURNS TRIGGER
AS $update_order_price$
    DECLARE
        delta numeric(14, 2)
    BEGIN
        -- Work out the increment/decrement amount(s).
        IF (TG_OP = 'INSERT') THEN
            delta = NEW.quantity * NEW.unitprice;
        ELSIF (TG_OP = 'UPDATE') THEN
            delta = NEW.quantity * NEW.unitprice - OLD.quantity * OLD.unitprice;
        ELSIF (TG_OP = 'DELETE') THEN
            delta = - OLD.quantity * OLD.unitprice;
        END IF;

        -- Update the order row
        UPDATE orders 
        SET totalamount = totalamount + delta
        WHERE id = OLD.orderid;

        RETURN NEW;
    END;
$update_order_price$ LANGUAGE plpgsql;