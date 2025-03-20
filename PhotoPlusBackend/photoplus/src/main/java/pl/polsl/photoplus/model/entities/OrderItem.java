package pl.polsl.photoplus.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.polsl.photoplus.annotations.Patchable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "orderItems")
@Table(name = "orderItems")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends AbstractEntityModel {

    public OrderItem(final Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Patchable
    private Integer quantity;

}
