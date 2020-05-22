enum ActivityLevel { LOW, MED, HIGH  }

class ActivityDescription
{
    String name;
    String otherDetails;
    String description; // etc..
    // perhaps also
    // ActivityLevel activityLevel;

    // constructor and getters
    // this is an immutable value object
}

interface ActivityDescriptionProvider
{
    ActivityDescription getDescription(ActivityLevel activityLevel);
}