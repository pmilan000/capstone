package org.launchcode.capstone.models.data;


import org.launchcode.capstone.models.CustomerDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails, Integer> {

}
