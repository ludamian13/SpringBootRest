package restApi.Service;

import restApi.Exceptions.NotFoundException;
import restApi.Model.Account;
import restApi.Model.Address;
import restApi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> find() {
        return accountRepository.findAll();
    }

    public Account show(int accountId) {
        Account account = accountRepository.findOne(accountId);

        verifyAccount(account);

        return account;
    }

    public Account create(String name, String email, String street, String city, String state) {

        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);

        return accountRepository.save(new Account(name, email, address));
    }

    public Account update(int accountId, String name, String email) {
        Account account = accountRepository.findOne(accountId);

        verifyAccount(account);

        account.setName(name);
        account.setEmail(email);
        return accountRepository.save(account);
    }

    public boolean delete(int accountId) {
        Account account = accountRepository.findOne(accountId);

        verifyAccount(account);

        accountRepository.delete(accountId);
        return true;
    }

    private void verifyAccount(Account account) {
        if (account == null) {
            throw new NotFoundException("No account found with this id");
        }
    }


}
