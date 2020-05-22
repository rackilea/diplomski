package de.mhaller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Assert;
import org.junit.Test;

public class Mailer {

    @Test
    public void testMailer() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Mail> log = new ArrayList<Mail>();
        LinkedBlockingDeque<Mail> incoming = new LinkedBlockingDeque<Mail>();

        // TODO: Put mails to be sent into the incoming queue
        incoming.offer(new Mail("foo1@localhost", "localhost"));
        incoming.offer(new Mail("foo2@otherhost", "otherhost"));
        incoming.offer(new Mail("foo3@otherhost", "otherhost"));
        incoming.offer(new Mail("foo4@localhost", "localhost"));

        Map<Mailserver, Queue<Mail>> queues = new HashMap<Mailserver, Queue<Mail>>();
        while (!incoming.isEmpty()) {
            Mail mail = incoming.pollFirst();
            Mailserver mailserver = findMailserver(mail);
            if (!queues.containsKey(mailserver)) {
                ArrayDeque<Mail> serverQueue = new ArrayDeque<Mail>();
                queues.put(mailserver, serverQueue);
                executor.execute(new SendMail(mailserver, serverQueue));
            }
            Queue<Mail> slot = queues.get(mailserver);
            slot.offer(mail);
        }

        assertMailSentWithCorrectServer(log);
    }

    private void assertMailSentWithCorrectServer(ArrayList<Mail> log) {
        for (Mail mail : log) {
            if (!mail.server.equals(mail.sentBy.mailserver)) {
                Assert.fail("Mail sent by wrong server: " + mail);
            }
        }
    }

    private Mailserver findMailserver(Mail mail) {
        // TODO: Your lookup logic which server to use
        return new Mailserver(mail.server);
    }

    private static class Mail {
        String recipient;
        String server;
        SendMail sentBy;

        public Mail(String recipient, String server) {
            this.recipient = recipient;
            this.server = server;
        }

        @Override
        public String toString() {
            return "mail for " + recipient;
        }
    }

    public static class SendMail implements Runnable {

        private final Deque<Mail> queue;
        private final Mailserver mailserver;

        public SendMail(Mailserver mailserver, Deque<Mail> queue) {
            this.mailserver = mailserver;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                Mail mail = queue.pollFirst();
                // TODO: Use SMTP to send the mail via mailserver
                System.out.println(this + " sent " + mail + " via " + mailserver);
                mail.sentBy = this;
            }
        }

    }

    public static class Mailserver {
        String hostname;

        public Mailserver(String hostname) {
            this.hostname = hostname;
        }

        @Override
        public String toString() {
            return hostname;
        }

        @Override
        public int hashCode() {
            return hostname.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return hostname.equals(((Mailserver) obj).hostname);
        }

    }

}