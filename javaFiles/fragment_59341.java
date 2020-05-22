task copyNoEncryption << { 
//copy to temp folder
copy {
    from("src/com/sql")
    into("src/temp/sql")
}
//copy back to correct folder and replace string's
copy {
    from("src/temp/sql")
    into("src/com/sql")

    filter {
 //you have to remember that first argument is REGEX and second is normal String
        String line ->
            line.replaceAll("before REGEX",
                    "after STRING")
    }
}
//delete temp folder
delete("src/temp")
}