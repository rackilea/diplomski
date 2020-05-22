String test = "\"IssueDetail\":\"IQR: ON THE FORM YOU MARKED YES TO THE FOLLOWING QUESTION: "
+ "Anything preventing you from completing the inspection? YOU NEED TO MARK \"NO\" "
+ "ON THIS PART. FURTHER DOWN THERE IS A QUESTION THAT STATES : Do you have "
+ "interior access to complete the inspection? THIS IS WHERE YOU ARE GOING TO "
+ "CHECK \"NO\" AND UPLOAD THE PHOTO. PLEASE COMPLETE THIS ON THE FORM AND "
+ "FOLLOW THE REST OF THE PROMPTS TO COMPLETE THE FULL EXTERIOR INSPECTION. "
+ "IF YOU HAVE ANY QUESTIONS PLEASE CONTACT YOUR VC. THANK YOU! "
+ "\",\"PhotoIssue\":true,\"FormIssue\":true,\"SendEmail\":true";

System.out.println(
    test.replaceAll("(?<!^|:|,)\"(?!:|,|$)", "\\\\\"")
);