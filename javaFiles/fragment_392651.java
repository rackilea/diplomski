function submitPage(){
     document.getElementById("citizenRegistration").action="getCitizen/citizen_registration.htm";
     document.getElementById("citizenRegistration").target="_self";    
     document.getElementById("citizenRegistration").method = "POST";
     document.getElementById("citizenRegistration").submit();
}