CREATE DEFINER=`XXXX`@`localhost` PROCEDURE `insertChildNode`(IN `nodeId` INT, IN `newNodeName` VARCHAR(50))
    LANGUAGE SQL
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN

    Rollback;

START TRANSACTION;

    SELECT @myRight := rgt FROM item_tree WHERE item_id = nodeId;

    UPDATE item_tree SET rgt = rgt + 2 WHERE rgt >= @myRight;
    UPDATE item_tree SET lft = lft + 2 WHERE lft > @myRight;
    INSERT INTO item_tree(item_name, lft, rgt) VALUES(newNodeName, @myRight , @myRight + 1);

COMMIT;

END