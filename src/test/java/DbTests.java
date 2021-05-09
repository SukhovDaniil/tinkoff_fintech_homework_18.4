import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.fintech.qa.homework.db.hibernate.DbHibernateService;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Place;
import ru.fintech.qa.homework.db.hibernate.models.Workman;
import ru.fintech.qa.homework.utils.BeforeUtils;

import java.util.List;

public class DbTests {
    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    @DisplayName("Количество записей в таблице")
    public void numberOfRecordsTest() {
        List<Animal> animals = DbHibernateService.getAllAnimals();

        Assertions.assertEquals(10, animals.size());
    }

    // Криво написано, но иначе я никак придумать не смог
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @ParameterizedTest(name = "Добавление существующей строки с индексом {0}")
    public void addingAnExistingLine(int index) {

        Animal animal = new Animal();
        animal.setId(index);

        Assertions.assertThrows(ConstraintViolationException.class, () -> DbHibernateService.addAnimal(animal));
    }

    @Test
    @DisplayName("Добавление рабочего без имени")
    public void addingWorkmanWithoutName() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> DbHibernateService.addWorkman(new Workman()));
    }

    @Test
    @DisplayName("Проверка количества записей после добавления новой")
    public void placesCountAfterAdding() {
        int id = DbHibernateService.addPlace(new Place());
        Assertions.assertEquals(6, DbHibernateService.getPlacesCount());
        DbHibernateService.deletePlaceById(id);
    }

    @Test
    @DisplayName("Список зоопарков")
    public void getZooList() {
        Assertions.assertEquals(
                3,
                DbHibernateService.getZooWithNameInList("Центральный", "Северный", "Западный").size()
        );
    }
}
