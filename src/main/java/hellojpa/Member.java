package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

}
