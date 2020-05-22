public void set (int newVal) {
        // Range check the input parameter
        // this should use the min/max bounds for the object's most derived class
        if (newVal < getMin() || newVal > getMax()) {
            throw new InvalidParameterException("`newVal` is out of range");
        }

        this._value = newVal;
    }