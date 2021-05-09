package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Place;
import ru.fintech.qa.homework.db.hibernate.models.Workman;
import ru.fintech.qa.homework.db.hibernate.models.Zoo;

import javax.persistence.PersistenceException;
import java.util.Arrays;
import java.util.List;

public class DbHibernateService {
    /**
     * @return - список из всех животных в таблице.
     */
    public static List<Animal> getAllAnimals() {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            return session.createNativeQuery("SELECT * FROM animal;", Animal.class).getResultList();
        }
    }

    /**
     * @param animal - объект животного.
     * @throws Throwable - причина PersistenceException.
     */
    public static void addAnimal(final Animal animal) throws Throwable {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(animal);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            throw e.getCause();
        }
    }

    /**
     * @param workman объект рабочего.
     * @throws Throwable причина PersistenceException.
     */
    public static void addWorkman(final Workman workman) throws Throwable {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(workman);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            throw e.getCause();
        }
    }

    /**
     * @param place объект загона.
     * @return идентификатор добавленного загона.
     */
    public static int addPlace(final Place place) {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            session.beginTransaction();
            int result = (int) session.save(place);
            session.getTransaction().commit();
            return result;
        }
    }

    /**
     * @return количество записей в таблице places.
     */
    public static Long getPlacesCount() {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            return (Long) session.createQuery("SELECT COUNT(id) FROM Place").getSingleResult();
        }
    }

    /**
     * @param id идентификатор удаляемого загона.
     */
    public static void deletePlaceById(final int id) {
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            Place place = session.get(Place.class, id);
            session.beginTransaction();
            session.delete(place);
            session.getTransaction().commit();
        }
    }

    /**
     * @param names список названий зоопарков.
     * @return список объектов зоопарков.
     */
    public static List<Zoo> getZooWithNameInList(final String... names) {
        String nameList = "('"
                + String.join("', '", Arrays.asList(names))
                + "')";

        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Zoo WHERE name IN" + nameList,
                    Zoo.class
            ).getResultList();
        }
    }
}