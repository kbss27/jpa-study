package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    private Integer age;

    private RoleType roleType;

    private Date createDate;

    private Date lastModifiedDate;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
