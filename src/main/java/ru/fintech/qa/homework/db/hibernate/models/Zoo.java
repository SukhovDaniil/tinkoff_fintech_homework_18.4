package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    private Integer id;
    @Column(name = "\"name\"")
    private String name;

    /**
     * @return идентификатор зоопарка.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id идентификатор зоопарка.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return название зоопарка.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name название зоопарка.
     */
    public void setName(final String name) {
        this.name = name;
    }
}
