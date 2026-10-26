package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="orders_table")
@Data
public class Order {
    @Id
    private Long id;
    private LocalDateTime orderDate;
    private String status;
}
