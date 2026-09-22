package dev.presetyx.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID customerId;
    private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
    protected Account() {}
    public Account(UUID customerId, String accountNumber) { this.customerId = customerId; this.accountNumber = accountNumber; }
    public UUID getId() { return id; }
    public UUID getCustomerId() { return customerId; }
    public String getAccountNumber() { return accountNumber; }
    public BigDecimal getBalance() { return balance; }
}
