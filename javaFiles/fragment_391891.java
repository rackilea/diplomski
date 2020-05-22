Map context = ... // this is your context map; filled with variable values
String message = parse(template, context);   // every engine has some way to apply context to the template

Email.create()
    .from("...@jodd.org")
    .to("...@jodd.org")
    .subject("Hello!")
    .addHtml(message);