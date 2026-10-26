package in.ashokit.runner;

import in.ashokit.entity.Customer;
import in.ashokit.entity.Order;
import in.ashokit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    CustomerRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        saveCustomer();
        fetchCustomer();
    }
    private void fetchCustomer() {
        Optional<Customer> byId = repository.findById(101L);
        /*
        if(byId.isPresent()) {
            Customer customer = byId.get();
            System.out.println(customer);
        }
        */
        byId.ifPresent(System.out::println);
    }
    private void saveCustomer() {
        Customer customer = new Customer();
        customer.setId(102L); customer.setName("Allen");

        Order order1 = new Order();
        order1.setId(65789L);
        order1.setOrderDate(LocalDateTime.of(2026, 10, 21, 17, 30, 35));
        order1.setStatus("Shipped");

        Order order2 = new Order();
        order2.setId(58891L);
        order2.setOrderDate(LocalDateTime.of(2026, 10, 24, 10, 11, 11));
        order2.setStatus("placed");

        Order order3 = new Order();
        order3.setId(20085L);
        order3.setOrderDate(LocalDateTime.of(2026, 10, 19, 15, 15, 55));
        order3.setStatus("refunded");

        List<Order> orderList = List.of(order1, order2, order3);
        customer.setOrderList(orderList);
        repository.save(customer);
    }
}
