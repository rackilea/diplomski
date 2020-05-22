<changeSet id="20161016_my_first_change2" author="krudland" context="dev">
    <sql>
        insert into customer (firstname, lastname) values ('Franklin','Ike');
    </sql>
    <rollback>
        delete from customer where firstname = 'Franklin' and lastname = 'Ike';
    </rollback>
</changeSet>