package org.example;

import org.example.DAO.ProduitDAO;
import org.example.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {


//        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
//
//
//        Session session = sessionFactory.openSession();
//
//        session.getTransaction().begin();

//        Produit pr = new Produit();
//        pr.setMarque("Nike");
//        pr.setReference("air");
//        pr.setDateAchat(Date.valueOf("2023-03-12"));
//        pr.setPrix(120.50);
//        pr.setStock(100);
//
//
//        Produit pr2 = new Produit();
//        pr2.setMarque("Adidas");
//        pr2.setReference("Stan");
//        pr2.setDateAchat(Date.valueOf("2023-04-12"));
//        pr2.setPrix(99.99);
//        pr2.setStock(500);
//
//
//
//
//        Produit pr3 = new Produit();
//        pr3.setMarque("Rebook");
//        pr3.setReference("gel");
//        pr3.setDateAchat(Date.valueOf("2023-09-12"));
//        pr3.setPrix(103.69);
//        pr3.setStock(300);
//
//
//
//
//        Produit pr4 = new Produit();
//        pr4.setMarque("Converse");
//        pr4.setReference("classic");
//        pr4.setDateAchat(Date.valueOf("2023-04-12"));
//        pr4.setPrix(69.25);
//        pr4.setStock(500);
//
//
//
//        Produit pr5 = new Produit();
//        pr5.setMarque("Levi's");
//        pr5.setReference("blue");
//        pr5.setDateAchat(Date.valueOf("2023-06-12"));
//        pr5.setPrix(105.65);
//        pr5.setStock(400);
//
//
//        session.save(pr);
//        session.save(pr2);
//        session.save(pr3);
//        session.save(pr4);
//        session.save(pr5);









//        Produit produit = session.load(Produit.class, 54);
//        System.out.println(produit);


//        Produit produitdelete = session.load(Produit.class, 55);
//        session.delete(produitdelete);

//        Produit produitupdate = session.load(Produit.class, 53);
//        produitupdate.setPrix(23.50);
//        produitupdate.setMarque("New marque");
//        session.update(produitupdate);
//
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();



        ProduitDAO produitDAO = new ProduitDAO();

//        List<Produit> produits = produitDAO.getAllProduit();
//
//        for(Produit p : produits) {
//            System.out.println(p);
//        }



//        List<Produit> produits1 = produitDAO.getAllProduitByPrice(100);
//
//        for(Produit p : produits1) {
//            System.out.println(p);
//        }

//        List<Produit> produits2 = produitDAO.getAllProduitBoughtBetween2dates("2023-05-12", "2023-07-12");
//
//        for(Produit p : produits2) {
//            System.out.println(p);
//        }

//        List<Produit> produits2 = produitDAO.getAllProduitReferenceByStock(450);
//
//        for(Produit p : produits2) {
//            System.out.println(p);
//        }

//        System.out.println(produitDAO.getValueOfStockOfProduct("Converse"));
//        System.out.println(produitDAO.getValueAverageOfProduct());


        produitDAO.deleteAllProductByMarque("Converse");
//        List<Produit> produits2 = produitDAO.getAllProductByMarque("Converse");
//
//        for(Produit p : produits2) {
//            System.out.println(p);
//        }
    }




}
