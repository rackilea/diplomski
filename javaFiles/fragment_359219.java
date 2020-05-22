<hibernate-configuration>

    <session-factory>
        <property name="hibernate.connection.url">${conn-string}</property>
        <property name="hibernate.connection.username">${db-user}</property>
        <property name="hibernate.connection.password">${db-pass}</property>
        <property name="hibernate.dialect">com.ftu.utils.FtuCustomOracleDialect</property>
        <property name="hibernate.connection.driver_class">oracle.jdbc.OracleDriver</property>
        <property name="hibernate.current_session_context_class">thread</property>

        <property name="connection.provider_class">org.hibernate.connection.C3P0ConnectionProvider</property>
        <property name="hibernate.c3p0.min_size">1</property>
        <property name="hibernate.c3p0.max_size">50</property>
        <property name="hibernate.c3p0.timeout">30000</property>
        <property name="hibernate.c3p0.checkoutTimeout">30000</property>
        <property name="hibernate.c3p0.max_statements">1</property>
        <property name="hibernate.c3p0.idle_test_period">100</property>

        <property name="show_sql">false</property>
        <property name="format_sql">true</property>

        <mapping class="com.assist.model.entity.Empresa " />
    </session-factory>
</hibernate-configuration>