package es.whinedo.pilots.springboot_docker.simple.controller;

import es.whinedo.pilots.springboot_docker.simple.model.Customer;
import es.whinedo.pilots.springboot_docker.simple.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("")
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        if (customerId != null && customer != null && customerRepository.exists(customerId)) {
            Customer oldCustomer = customerRepository.findOne(customerId);
            oldCustomer.setFirstName(customer.getFirstName());
            oldCustomer.setLastName(customer.getLastName());
            return customerRepository.save(oldCustomer);
        }
        return null;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerRepository.findOne(customerId);

    }

}
