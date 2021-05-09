package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workman")
public class Workman {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "\"position\"")
    private Integer position;

    /**
     * @return - идентификатор работника.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - идентификатор работника.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return - имя работника.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - имя работника.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return - возраст работника.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age - возраст работника.
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * @return - идентификатор должности.
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * @param position - идентификатор должности.
     */
    public void setPosition(final Integer position) {
        this.position = position;
    }
}
