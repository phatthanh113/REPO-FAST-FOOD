package com.a07.sprint3_fastfood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;
    private Double amount;
    private Double amountOrder;
    @org.hibernate.annotations.Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;
    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private List<TypeFood> typeFoods;
    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private List<CommentEvaluate> commentEvaluates;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;
}
