package restApi.Controller;

import org.springframework.web.bind.annotation.*;
import restApi.Model.Address;
import restApi.Model.Product;
import restApi.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class AddressControler {

    @Autowired
    AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> find() {
        return addressService.find();
    }

    @GetMapping("/address")
    public Address show(@RequestParam int addressId) {
        return addressService.show(addressId);
    }

    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public Address create(@RequestParam("name") String street, @RequestParam("city") String city, @RequestParam("state") String state) {
        return addressService.create(street, city, state);
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public Address update(@RequestParam int addressId, @RequestParam("name") String street, @RequestParam("city") String city, @RequestParam("state") String state) {
        return addressService.update(addressId, street, city, state);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int addressId) {
        return addressService.delete(addressId);
    }



}
