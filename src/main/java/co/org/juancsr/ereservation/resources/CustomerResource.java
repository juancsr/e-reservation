package co.org.juancsr.ereservation.resources;

import co.org.juancsr.ereservation.model.Customer;
import co.org.juancsr.ereservation.resources.vo.CustomerVO;
import co.org.juancsr.ereservation.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that represents the customer web service
 * @author juancsr
 */
@RestController
@RequestMapping(name = "/api/customer")
@Api(tags = "customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ApiOperation(value = "customer create", notes = "Service to create a new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "customer created"),
            @ApiResponse(code = 404, message = "invalid request")
    })
    public ResponseEntity<Customer> create(@RequestBody CustomerVO customer) {
        Customer c = new Customer();
        c.setName(customer.getName());
        c.setIdentify(customer.getIdentify());
        c.setLastname(customer.getLastname());
        c.setAddress(customer.getAddress());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());
        return new ResponseEntity<>(this.customerService.create(c), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "customer update", notes = "Service to update a customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "customer updated"),
            @ApiResponse(code = 404, message = "invalid request")
    })
    public ResponseEntity<Customer> update(@PathVariable("id") String id, CustomerVO customerVO) {
        Customer customer = this.customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            Customer c = new Customer();
            c.setName(customerVO.getName());
            c.setLastname(customerVO.getLastname());
            c.setAddress(customerVO.getAddress());
            c.setEmail(customerVO.getEmail());
            c.setPhone(customerVO.getPhone());
            return new ResponseEntity<>(this.customerService.update(c), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "customer delete", notes = "Service to delete a customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "customer removed"),
            @ApiResponse(code = 404, message = "invalid request")
    })
    public void delete(@PathVariable("id") String id) {
        Customer customer = this.customerService.findById(id);
        if (customer != null) {
            this.customerService.delete(customer);
        }
    }

    @GetMapping
    @ApiOperation(value = "find all", notes = "Service to get all customers")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "customer updated"),
            @ApiResponse(code = 404, message = "invalid request")
    })
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(this.customerService.findAll());
    }
}
