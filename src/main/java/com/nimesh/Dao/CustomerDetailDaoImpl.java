package com.nimesh.Dao;

import com.nimesh.Entity.CustomerDetail;
import com.nimesh.Repository.CustomerDetailRepository;
import com.nimesh.Repository.CustomerDetailRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDetailDaoImpl implements CustomerDetailRepositoryCustom {

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Override
    public CustomerDetail createCustomerDetail(CustomerDetail customerDetail) {
        return this.customerDetailRepository.save(customerDetail);
    }

    @Override
    public List<CustomerDetail> getCustomerDetail() {
        return this.customerDetailRepository.findAll();
    }

    @Override
    public CustomerDetail getCustomerById(Long id) {
        return this.customerDetailRepository.findOne(id);
    }

    @Override
    public void updateCustomer(CustomerDetail customerDetail) {
        this.customerDetailRepository.save(customerDetail);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerDetailRepository.delete(id);
    }
}
