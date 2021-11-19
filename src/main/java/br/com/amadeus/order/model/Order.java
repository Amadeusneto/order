package br.com.amadeus.order.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    @NotNull(message = "O numero controle deve ser preenchido.")
    @Column(unique = true)
    private Long controlNumber;

    private LocalDate registrationDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String formattedString = registrationDate.format(formatter);

    private Integer quantity = 1;

    @NotNull(message = "O código cliente deve ser preenchido.")
    private Long clientCode;

    private Double orderTotal;
}
