package ac.za.cput.OlympicsApp.services;

import java.util.Set;

/**
 * Created by lodz on 2016/08/18.
 */
public interface Service<E,ID> {
    E create(E entity);

    E readById(ID id);

    E update(E entity);

    void delete(E entity);

    Set<E> readAll();

}
