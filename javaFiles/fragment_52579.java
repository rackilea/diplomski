public void lerEmail() {
        try {
            campolog.setContentType("text/html");
            // (1) Informações do Servidor
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            Session session = Session.getInstance(props);

            // (2) Conexão com o servidor
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "email@email.com.br", "senha");

            // Buscar referência das pastas (Não precisa tirar o comentario, só se você quiser saber o nome das pastas).
//            Folder[] nomePastas = store.getDefaultFolder().list("*");
//            for (Folder pasta : nomePastas) {
//                if ((pasta.getType() & Folder.HOLDS_MESSAGES) != 0) {
//                    System.out.println(pasta.getFullName() + ": " + pasta.getMessageCount());
//                }
//            }

            // (3) Escolhemos a pasta INBOX e colocamos no modo "Ler e Escrever (READ_WRITE)" (Isso "autoriza" a modificação de "Não Lido" para "Lido")
            SortTerm[] termos = new SortTerm[1];
            termos[0] = SortTerm.ARRIVAL;
            Folder pastaEmail = store.getFolder("INBOX");
            pastaEmail.open(Folder.READ_WRITE);

            // (4) Cria filtro para mensagens não lidas.
            Flags visto = new Flags(Flags.Flag.SEEN);
            FlagTerm filtroNaoLidas = new FlagTerm(visto, false);

            // (5) Cria filtro para "ler" apenas um "endereço".
            FromStringTerm filtroEmail = new FromStringTerm("@abnerRodrigues.com.br"); //Se você quiser ler email de apenas um destinatário, faça a modificação

            // (6) Combina os filtros em um só.
            SearchTerm filtros = new AndTerm(filtroNaoLidas, filtroEmail);

            //Message[] mensagens = pastaEmail.getMessages(); //Aqui pega todas os emails.
            Message[] mensagens = pastaEmail.search(filtros); //Aqui filtra os emails de acordo com o que queremos.
            for (int q = 0; q < mensagens.length; q++) {
                mensagens[q].setFlag(Flag.SEEN, true);
            }

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        pastaEmail.open(Folder.READ_WRITE);
                        // Fazemos a primeira leitura de emails.
                        int start = 1;
                        int end = pastaEmail.getMessageCount();
                        while (start <= end) {
                            // new messages that have arrived
                            start = end + 1;
                            end = pastaEmail.getMessageCount();
                        }

                       // Adicionando um MessageCountListener to "ouvir" novas mensagens
                        pastaEmail.addMessageCountListener(new MessageCountAdapter() {
                            @Override
                            public void messagesAdded(MessageCountEvent ev) {
                                try {
                                    Message[] msgs = pastaEmail.search(filtros);
                                    for (Message msg : msgs) {
                                        Notificacao nf = new Notificacao();
                                        nf.setVisible(true);
                                        dispose();
                                    }
                                } catch (MessagingException ex) {
                                    Logger.getLogger(Notificacao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                        // Aguardando novas mensagens
                        for (;;) {
                            ((IMAPFolder) pastaEmail).idle();
                        }
                    } catch (MessagingException ex) {
                        Logger.getLogger(Notificacao.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }, delay, interval);

            //System.out.println("Total de E-mails: " + mensagens.length);
            if (mensagens.length > 0) {
                int ultimaMensagem = mensagens.length - 1;
                campolog.setText("Mensagem: " + mensagens[ultimaMensagem].getContent().
            } else {
                System.out.println("Não há E-mails não lidos.");
                campotelefone.setText("");
                campolog.setText("<html><head></head><body><b> <center><font face= Arial><font size=6><font color=black> NÃO HÁ RESPOSTA DO MORADOR! </font></center></b></body></html>");
            }
            pastaEmail.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            System.out.println("Erro: " + e);
        } catch (MessagingException | IOException e) {
            System.out.println("Erro: " + e);
        }
    }