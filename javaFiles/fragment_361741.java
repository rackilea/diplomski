public abstract class ContactInfo { /* ... */ }

public class Address extends ContactInfo { /* ... */ }

public class PhoneNumber extends ContactInfo { /* ... */ }

public class EmailAddress extends ContactInfo { /* ... */ }

public class Contact {
    private String name;
    private Set<ContactInfo> info;
    // ...
}