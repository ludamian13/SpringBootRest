package restApi.Controller;

import restApi.Model.Account;
import restApi.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> find() {
        return accountService.find();
    }

    @GetMapping("/account")
    public Account show(@RequestParam int accountId) {
        return accountService.show(accountId);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public Account create(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("state") String state) {
        return accountService.create(name, email, street, city, state);
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public Account update(@RequestParam int accountId, @RequestParam("name") String name, @RequestParam("email") String email) {
        return accountService.update(accountId, name, email);
    }

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int accountId) {
        return accountService.delete(accountId);
    }
}
