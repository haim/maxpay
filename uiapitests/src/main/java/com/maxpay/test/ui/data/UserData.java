package com.maxpay.test.ui.data;

import javafx.util.Builder;

public class UserData {


    private final String email;
    private final String emailConfirmation;
    private final String password;
    private final String passwordConfirmation;

    private UserData(Builder builder) {
        this.email = builder.email;
        this.emailConfirmation = builder.emailConfirmation;
        this.password = builder.password;
        this.passwordConfirmation = builder.passwordConfirmation;
    }

    public String getEmailConfirmation() {
        return emailConfirmation;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public static class Builder {
        private String email;
        private String emailConfirmation;
        private String password;
        private String passwordConfirmation;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder emailConfirmation(String emailConfirmation) {
            this.emailConfirmation = emailConfirmation;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder passwordConfirmation(String passwordConfirmation) {
            this.passwordConfirmation = passwordConfirmation;
            return this;
        }

        public UserData build() {
            return new UserData(this);
        }
    }


    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", emailConfirmation='" + emailConfirmation + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                '}';
    }

}
