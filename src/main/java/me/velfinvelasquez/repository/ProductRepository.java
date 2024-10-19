package me.velfinvelasquez.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import me.velfinvelasquez.entities.Product;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager em;

    public void createProducto(Product p) {
        em.persist(p);
    }

    public List<Product> listProduct() {
        @SuppressWarnings("unchecked")
        List<Product> list = em.createQuery("select p from Product p").getResultList();
        return list;

    }

    public void deleteById(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

}
