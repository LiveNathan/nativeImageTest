package dev.nathanlively.nativeImageTest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private String username;
    @JsonIgnore
    private String hashedPassword;
    private Set<Role> roles;
    private byte[] profilePicture;

    private Account(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.roles = new HashSet<>(Set.of(Role.USER));
        this.profilePicture = new byte[0];
    }

    public static Account create(String username, String hashedPassword) {
        return new Account(username, hashedPassword);
    }

    public String username() {
        return username;
    }

    public byte[] profilePicture() {
        return profilePicture;
    }

    public String hashedPassword() {
        return hashedPassword;
    }

    public Set<Role> roles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return username.equals(account.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
