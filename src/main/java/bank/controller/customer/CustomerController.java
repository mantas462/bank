package bank.controller.customer;


import bank.dto.customer.CustomerDto;
import bank.entity.customer.CustomerType;
import bank.service.customer.CustomerService;
import bank.util.api.RestUrl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping(value = RestUrl.CUSTOMER_BY_UUID)
    public CustomerDto get(@PathVariable(value = "id") BigInteger id) {

        return customerService.getByIdAndType(id, CustomerType.BUSINESS);
    }
}
