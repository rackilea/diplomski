<bean id="cloudinaryConfigMap" class="java.util.HashMap">
    <constructor-arg>
        <map key-type="java.lang.String" value-type="java.lang.String">
            <entry key="api_key" value="${cloudinary.api.key}" />
            <entry key="api_secret" value="${cloudinary.api.secret}" />
            <entry key="cloud_name" value="${cloudinary.cloud-name}" />
            <entry key="callback" value="$[app.url.base]/path/to/cloudinary_cors.html" />
        </map>
    </constructor-arg>
</bean>

<bean id="cloudinary" class="com.cloudinary.Cloudinary">
    <constructor-arg index="0" ref="cloudinaryConfigMap" />
</bean>

<bean id="cloudinarySingleton" class="com.cloudinary.SingletonManager" 
    init-method="init" destroy-method="destroy">
    <property name="cloudinary" ref="cloudinary" />
</bean>