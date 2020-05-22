private String surname;

.....{
    ....
    surname = jsonObject.getString("surname");
    ...
}

public void DrawText() {
        Log.e(TAG, "string surname: " + surname);

        // Displaying the user details on the screen
        inputSurname.setText(surname);
    }