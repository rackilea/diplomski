<authentication-manager>
    <authentication-provider>
        <user-service>
            <user name="${admin.username}" password="${admin.password}" authorities="user,administrator" />
            <user name="${user.username}" password="${user.password}" authorities="user" />
        </user-service>
    </authentication-provider>
</authentication-manager>