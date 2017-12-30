package com.nimesh.Service;

import com.nimesh.Dao.CustomerDetailDaoImpl;
import com.nimesh.Entity.CustomerDetail;
import com.nimesh.Response.ApiReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailService {

    @Autowired
    private CustomerDetailDaoImpl customerDetailDao;

    public ApiReponse createCustomerDetails(CustomerDetail customerDetail) {
        CustomerDetail detail = customerDetailDao.createCustomerDetail(customerDetail);
        if (detail == null) {
            return new ApiReponse("false", "something went wrong");
        }
        return new ApiReponse("true", "customer detail created successfully");
    }

    public List<CustomerDetail> getCustomerDetails() {
        return this.customerDetailDao.getCustomerDetail();
    }

    public ResponseEntity getCustomerById(Long id) {
        CustomerDetail customerDetail = customerDetailDao.getCustomerById(id);
        if (customerDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customerDetail);
    }

    public ApiReponse updateCustomer(Long id, CustomerDetail customerDetail) {
        CustomerDetail detail = customerDetailDao.getCustomerById(id);
        if (detail == null) {
            return new ApiReponse("false", "customer detail not found");
        }
        detail.setCompanyName(customerDetail.getCompanyName());
        detail.setContactName(customerDetail.getContactName());

        customerDetailDao.updateCustomer(detail);
        return new ApiReponse("true", "customer detail updated");
    }

    public ApiReponse deleteCustomer(Long id) {
        CustomerDetail detail = customerDetailDao.getCustomerById(id);
        if (detail == null) {
            return new ApiReponse("false", "customer detail not found");
        }
        customerDetailDao.deleteCustomer(id);
        return new ApiReponse("true", "customer detail deleted successfully");
    }
}
