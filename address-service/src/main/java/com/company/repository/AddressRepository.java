package com.company.repository;

import com.company.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(
            nativeQuery = true,
            value =
                    "select ea.id, ea.city, ea.state from address ea join employee e on e.id=ea.employee_id where ea.employee_id=:employeeId"
    )
    Optional<Address> findAllByEmployeeId(@Param("employeeId") int employeeId);
}
