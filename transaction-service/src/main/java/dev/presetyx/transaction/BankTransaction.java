package dev.presetyx.transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
public class BankTransaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID accountId;
    private String type;
    private BigDecimal amount;
    private Instant createdAt = Instant.now();
    protected BankTransaction() {}
    public BankTransaction(UUID accountId, String type, BigDecimal amount) { this.accountId = accountId; this.type = type; this.amount = amount; }
    public UUID getId() { return id; }
    public UUID getAccountId() { return accountId; }
    public String getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public Instant getCreatedAt() { return createdAt; }
}
