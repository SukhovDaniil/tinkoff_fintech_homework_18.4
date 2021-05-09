package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private Integer id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "\"type\"")
    private Integer type;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "place")
    private Integer place;

    /**
     * @return - идентификатор животного.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id - идентификатор животного.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return - имя животного.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - имя животного.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return - возраст животного.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age - возраст животного.
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * @return - тип животного:
     * 1 - Кошка,
     * 2 - Собака,
     * 3 - Примат,
     * 4 - Птица,
     * 5 - Рыба.
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type - тип животного:
     *             1 - Кошка
     *             2 - Собака
     *             3 - Примат
     *             4 - Птица
     *             5 - Рыба
     */
    public void setType(final Integer type) {
        this.type = type;
    }

    /**
     * @return sex - пол животного: 1 - мужской, 2 - женский.
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex - пол животного: 1 - мужской, 2 - женский.
     */
    public void setSex(final Integer sex) {
        this.sex = sex;
    }

    /**
     * @return - идентификатор загона.
     */
    public Integer getPlace() {
        return place;
    }

    /**
     * @param place - идентификатор загона.
     */
    public void setPlace(final Integer place) {
        this.place = place;
    }

    /**
     * @param o - животное, с которым сравнивается текущее.
     * @return true - одинаковые, false - разные.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return id == animal.id
                && Objects.equals(name, animal.name)
                && Objects.equals(age, animal.age)
                && Objects.equals(type, animal.type)
                && Objects.equals(sex, animal.sex)
                && Objects.equals(place, animal.place);
    }

    /**
     * @return - хэш-код животного.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, type, sex, place);
    }

    /**
     * @return - строка с информацией о животном.
     */
    @Override
    public String toString() {
        return "Animal{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + ", type=" + type
                + ", sex=" + sex
                + ", place=" + place
                + '}';
    }
}
