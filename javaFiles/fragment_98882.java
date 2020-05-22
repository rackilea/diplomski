package com.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<Boolean> {

    private final StringProperty username = new SimpleStringProperty(this, "username");
    public final void setUsername(String username) { this.username.set(username); }
    public final String getUsername() { return username.get(); }
    public final StringProperty usernameProperty() { return username; }

    private final StringProperty password = new SimpleStringProperty(this, "password");
    public final void setPassword(String password) { this.password.set(password); }
    public final String getPassword() { return password.get(); }
    public final StringProperty passwordProperty() { return password; }

    @Override
    protected Task<Boolean> createTask() {
        return new LoginTask(getUsername(), getPassword());
    }

    private static class LoginTask extends Task<Boolean> {

        private final String username;
        private final String password;

        public LoginTask(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected Boolean call() throws Exception {
            Thread.sleep(3_000L); // simulate long running work...
            return !isCancelled() && "root".equals(username) && "root".equals(password);
        }

    }

}