package dev.presetyx.account;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final CustomerRepository customers;
    private final AccountRepository accounts;
    public AccountController(CustomerRepository customers, AccountRepository accounts) { this.customers = customers; this.accounts = accounts; }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody CreateCustomer request) { return customers.save(new Customer(request.name(), request.email())); }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable UUID id) { return customers.findById(id).orElseThrow(); }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody CreateAccount request) { if (!customers.existsById(request.customerId())) throw new IllegalArgumentException("Customer not found"); return accounts.save(new Account(request.customerId(), "BR" + System.currentTimeMillis())); }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable UUID id) { return accounts.findById(id).orElseThrow(); }

    public record CreateCustomer(@NotBlank String name, @NotBlank @Email String email) {}
    public record CreateAccount(UUID customerId) {}
}
