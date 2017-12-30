package com.nimesh.Controller;

import com.nimesh.Entity.CustomerDetail;
import com.nimesh.Response.ApiReponse;
import com.nimesh.Service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/distributor")
public class CustomerDetailController {

    @Autowired
    private CustomerDetailService customerDetailService;

    @GetMapping("/list")
    public List<CustomerDetail> getCustomerDetails() {
        return customerDetailService.getCustomerDetails();
    }

    @PostMapping("/create")
    public ApiReponse createDistributor(@Valid @RequestBody CustomerDetail customerDetail) {
        return customerDetailService.createCustomerDetails(customerDetail);

    }

    @GetMapping("/list/{id}")
    public ResponseEntity getCustomerById(@PathVariable(value = "id") Long custId) {
        return customerDetailService.getCustomerById(custId);
    }

    @PutMapping("/list/{id}")
    public ApiReponse updateCustomer(@PathVariable(value = "id") Long custId,
                                           @Valid @RequestBody CustomerDetail customerDetail1) {
        return customerDetailService.updateCustomer(custId, customerDetail1);
    }

    @DeleteMapping("/list/{id}")
    public ApiReponse deleteCustomer(@PathVariable(value = "id") Long custId) {
        return customerDetailService.deleteCustomer(custId);
    }
}
