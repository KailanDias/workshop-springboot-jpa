package org.enterprise.course.config;

import org.enterprise.course.entities.*;
import org.enterprise.course.entities.enums.OrderStatus;
import org.enterprise.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {


        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        Product p1 = new Product(null, "The lord of the Rings", "Lorem ipsun, ksnja jnfeoi caokns", 90.5,"" );
        Product p2 = new Product(null, "Smart TV", "Lorem ipsun, ksnja jnfeoi caokns", 2190.0,"");
        Product p3 = new Product(null, "Macbook Pro", "Lorem ipsun, ksnja jnfeoi caokns", 1250.0,"");
        Product p4 = new Product(null, "PC Gamer", "Lorem ipsun, ksnja jnfeoi caokns",1200.0,"" );
        Product p5 = new Product(null, "Rails for Dummies", "Lorem ipsun, ksnja jnfeoi caokns", 100.99,"");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Maria Brown", "Maria@gmail.com", "9999999", "299216");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "8888888", "5351889");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT ,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1,p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1,p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2,p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3,p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));



    }







}
