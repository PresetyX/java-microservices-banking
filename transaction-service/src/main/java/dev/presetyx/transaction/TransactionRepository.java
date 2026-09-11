package dev.presetyx.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<BankTransaction, UUID> {
    List<BankTransaction> findByAccountIdOrderByCreatedAtDesc(UUID accountId);
}
