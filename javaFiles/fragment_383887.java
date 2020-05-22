<persistence-unit name="BPM" transaction-type="${persistence-unit.transaction-type}">
    <!-- snip -->
    <properties>
        <!-- snip -->
        <property name="hibernate.show_sql" value="true" />
        <!-- snip -->
    </properties>
</persistence-unit>