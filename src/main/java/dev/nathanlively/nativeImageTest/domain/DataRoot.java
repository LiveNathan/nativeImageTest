package dev.nathanlively.nativeImageTest.domain;

public class DataRoot {
    private final Accounts accounts = new Accounts();

    public DataRoot() {
        super();
    }

    public Accounts accounts() {
        return accounts;
    }

    public void clear() {
        accounts.all().clear();
    }
}
