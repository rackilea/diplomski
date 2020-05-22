passwordDictionary.stream().parallel().forEach(password -> { 
               setPassword(password);
               decrypt(secret)
               setPassword(password+numbers);
               decrypt(secret)
})