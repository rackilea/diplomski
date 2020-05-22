if (!Common.isValidLength(fName)) {
        medFirstName.setError("Invalid First Name");
    }
    if (!Common.isValidLength(lName)) {
        medLastName.setError("Invalid Last Name");
    }
    if (!Common.isValidEmail(email)) {
        medEmailId.setError("Invalid Email");
    }
    if (!Common.isValidPassword(pass)) {
        medPassword.setError("Invalid Password");
    }
    if (!Common.isValidPassword(confirmPassword)) {
        medConfirmPassword.setError("Invalid Confirm Password");
    }
    if (!Common.isValidMatchPassword(pass, confirmPassword)) {
        medConfirmPassword.setError("Password does not match");
    }