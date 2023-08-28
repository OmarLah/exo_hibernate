package org.example.DAO;

import org.example.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;


public class ProduitDAO {



    public boolean addProduit(Produit produit) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            session.save(produit);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
           session.close();
        }
    }

    public boolean deleteProduit(int ProduitId) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Produit produit = session.load(Produit.class,ProduitId);
            if(produit != null){
                session.delete(produit);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }


    public List<Produit> getAllProduit() {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Produit> produitsQuery = session.createQuery("from Produit");
        List<Produit> produits = produitsQuery.list();
        return produits;
    }

    public List<Produit> getAllProduitByPrice(double price) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Produit> produitsQuery = session.createQuery("from Produit where prix > " + price);
        List<Produit> produits = produitsQuery.list();
        return produits;
    }

    public List<Produit> getAllProduitBoughtBetween2dates(String date1, String date2) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Produit> produitsQuery = session.createQuery("from Produit where dateAchat BETWEEN : date1 AND : date2" );
        produitsQuery.setParameter("date1", java.sql.Date.valueOf(date1));
        produitsQuery.setParameter("date2", java.sql.Date.valueOf(date2));
        List<Produit> produits = produitsQuery.list();
        return produits;
    }

    public List<Produit> getAllProduitReferenceByStock(int stock) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Produit> produitsQuery = session.createQuery("from Produit where stock < " + stock);
        List<Produit> produits = produitsQuery.list();

        return produits;
    }


    public double getValueOfStockOfProduct(String marque) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Double> queryValueProduit = session.createQuery("select sum(prix * stock) from Produit where marque = :marque");
        queryValueProduit.setParameter("marque",marque);
        double SumValue = queryValueProduit.uniqueResult();

        return SumValue;
    }

    public double getValueAverageOfProduct() {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Double> queryValueProduit = session.createQuery("select avg(prix) from Produit" );
        double SumValue = queryValueProduit.uniqueResult();

        return SumValue;
    }

    public List getAllProductByMarque(String marque) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Produit> queryListProduit = session.createQuery("from Produit where marque = :marque");
        queryListProduit.setParameter("marque",marque);
        List<Produit> produits = queryListProduit.list();

        return produits;
    }

    public void deleteAllProductByMarque(String marque) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();


        Query<Produit> queryListProduit = session.createQuery("select from Produit where marque = : marque");
        queryListProduit.setParameter("marque",marque);
        List<Produit> produits = queryListProduit.list();

    }


}
