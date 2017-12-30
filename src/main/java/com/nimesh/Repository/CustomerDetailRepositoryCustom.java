package com.nimesh.Repository;

import com.nimesh.Entity.CustomerDetail;

import java.util.List;

public interface CustomerDetailRepositoryCustom {

    CustomerDetail createCustomerDetail(CustomerDetail customerDetail);
    List<CustomerDetail> getCustomerDetail();
    CustomerDetail getCustomerById(Long id);
    void updateCustomer(CustomerDetail customerDetail);
    void deleteCustomer(Long id);
}
