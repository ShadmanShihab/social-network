package Controller;

import Model.Account;
import Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('Role_User')")
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @PostMapping("/demo")
    @PreAuthorize("hasAuthority('Role_User')")
    public Account addDemoAccount() {
        Account account = new Account("shadman", "12345", "user");
        accountRepository.save(account);

        return account;
    }
}
