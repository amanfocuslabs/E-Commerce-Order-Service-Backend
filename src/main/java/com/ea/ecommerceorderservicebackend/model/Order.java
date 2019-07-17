package com.ea.ecommerceorderservicebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "order_table")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    private String orderNumber;
    @Column(name = "order_lines")
    @JsonManagedReference(value = "order")
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines = new ArrayList<>();
    private Date orderDate;
    private Long paymentId;
    private Double tax;
    private Long shippingId;

    public void addOrderLine(OrderLine orderLine){
        this.orderLines.add(orderLine);
    }
}
