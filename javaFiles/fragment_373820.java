<application>
    ...

    <!-- disable default provider -->
    <provider
        android:name="androidx.work.impl.WorkManagerInitializer"
        android:authorities="${applicationId}.workmanager-init"
        android:exported="false"
        android:enabled="false"/>

    <!-- register custom provider -->
    <provider
        android:name=".CustomWorkManagerInitializer"
        android:authorities="${applicationId}.WorkManagerInit"/>

</application>