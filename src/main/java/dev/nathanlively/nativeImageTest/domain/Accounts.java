package dev.nathanlively.nativeImageTest.domain;

import java.util.*;


public class Accounts {

    private final Map<String, Account> usernameToAccount = new HashMap<>();

    public Accounts() {
        super();
    }

    public Map<String, Account> usernameToAccount() {
        return usernameToAccount;  // Collections.unmodifiableMap will not work here!
    }

    public void add(final Account account) {
        this.addToCollection(account);
    }

    public void addAll(final Collection<? extends Account> accounts) {
        accounts.forEach(this::addToCollection);
    }

    private void addToCollection(final Account account) {
        this.usernameToAccount.put(account.username(), account);
    }

    public List<Account> all() {
        return this.usernameToAccount.values()
                .stream()
                .sorted(Comparator.comparing(Account::username))
                .toList();
    }

    public Account byUsername(String username) {
        return this.usernameToAccount.get(username);
    }

    public Set<String> getAllUsernames() {
        return new TreeSet<>(usernameToAccount.keySet());
    }
}
