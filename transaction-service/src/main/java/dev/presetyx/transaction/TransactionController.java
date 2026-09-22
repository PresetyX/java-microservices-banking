package dev.presetyx.transaction;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionRepository repository;
    public TransactionController(TransactionRepository repository) { this.repository = repository; }

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public BankTransaction deposit(@Valid @RequestBody MoneyRequest request) { return repository.save(new BankTransaction(request.accountId(), "DEPOSIT", request.amount())); }

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.CREATED)
    public BankTransaction withdraw(@Valid @RequestBody MoneyRequest request) { return repository.save(new BankTransaction(request.accountId(), "WITHDRAWAL", request.amount())); }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BankTransaction> transfer(@Valid @RequestBody TransferRequest request) { return repository.saveAll(List.of(new BankTransaction(request.fromAccountId(), "TRANSFER_OUT", request.amount()), new BankTransaction(request.toAccountId(), "TRANSFER_IN", request.amount()))); }

    @GetMapping("/account/{accountId}")
    public List<BankTransaction> history(@PathVariable UUID accountId) { return repository.findByAccountIdOrderByCreatedAtDesc(accountId); }

    public record MoneyRequest(@NotNull UUID accountId, @NotNull @DecimalMin("0.01") BigDecimal amount) {}
    public record TransferRequest(@NotNull UUID fromAccountId, @NotNull UUID toAccountId, @NotNull @DecimalMin("0.01") BigDecimal amount) {}
}
