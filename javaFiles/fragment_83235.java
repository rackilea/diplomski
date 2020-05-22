String fromEmail = "sample@gmail.com";
                            String fromPassword = "xxxxxx";
                            String toEmails = to_sample@gmail.com;
                            String adminEmail = "admin@gmail.com";
                            String emailSubject = "App Registration Mail";
                            String adminSubject = "App Registration Mail";
                            String emailBody = "Your message";
                            String adminBody = "Your message";
                            new SendMailTask(YOurActivity.this).execute(fromEmail,
                                    fromPassword, toEmails, emailSubject, emailBody);