//File: phone.proto
//
//Optional Embedded C internal options:
//@max_repeated_length=100
//@max_string_length=32
enum PhoneType {  
MOBILE = 0;  
HOME = 1;  
WORK = 2;
}

message PhoneNumber {
 required string number = 1;  
 required PhoneType type = 2;
}