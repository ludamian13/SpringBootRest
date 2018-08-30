package restApi.Service;

import restApi.Model.Address;
import restApi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> find() {
        return addressRepository.findAll();
    }

    public Address show(int accountId) {
        return addressRepository.findOne(accountId);
    }

    public Address create(String street, String city, String state) {
        return addressRepository.save(new Address(street, city, state));
    }

    public Address update(int addressId, String street, String city, String state) {
        Address address = addressRepository.findOne(addressId);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        return addressRepository.save(address);
    }

    public boolean delete(int addressId) {
        addressRepository.delete(addressId);
        return true;
    }

}
