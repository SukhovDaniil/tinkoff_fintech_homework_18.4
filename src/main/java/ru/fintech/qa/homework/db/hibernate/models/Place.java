package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public class Place {
    @Id
    private int id;
    @Column(name = "\"row\"")
    private Integer row;
    @Column(name = "place_num")
    private Integer placeNum;
    @Column(name = "\"name\"")
    private String name;

    /**
     * @return идентификатор загона.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id идентификатор загона.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return ряд.
     */
    public Integer getRow() {
        return row;
    }

    /**
     * @param row ряд.
     */
    public void setRow(final Integer row) {
        this.row = row;
    }

    /**
     * @return номер загона.
     */
    public Integer getPlaceNum() {
        return placeNum;
    }

    /**
     * @param placeNum номер загона.
     */
    public void setPlaceNum(final Integer placeNum) {
        this.placeNum = placeNum;
    }

    /**
     * @return название загона.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name название загона.
     */
    public void setName(final String name) {
        this.name = name;
    }
}
