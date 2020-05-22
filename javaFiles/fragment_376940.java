<provider
        android:name="android.support.v4.content.FileProvider"
        android:authorities="${applicationId}.com.mydomain.fileprovider"
        android:exported="false"
        android:grantUriPermissions="true"
        tools:replace="android:authorities">
        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/picker_provider_paths" />
    </provider>