package hellojpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;
    private String name;
    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;
}
