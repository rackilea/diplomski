class Dog {
    // Must have initial value, default getter and setter. Value can come from constructor.
    val isNice: Boolean = true 
        set(value) { ... } // This produces an error, no setters on vals

    // Must have initial value, default getter
    var age: Int = 0 
        set(value) { if (value >= 0) field = value }

    // Value is just computed, has no field and cannot have initial value
    var ageInDogYears: Int 
        get() = age * 7
        set(value) { age = value / 7 }
}