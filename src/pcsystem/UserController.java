/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pcsystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Uday
 */
public class UserController {

     private EntityManagerFactory emf;
 private EntityManager getEntityManager() {
 if(emf == null){
 emf = Persistence.createEntityManagerFactory("PCSystemPU");
 }
 return emf.createEntityManager();
 }

 public Users[] getUsers() {
 EntityManager em = getEntityManager();
 try{
 javax.persistence.Query q = em.createQuery("select c from PRODUCT_DETAILS as c");
 return (Users[]) q.getResultList().toArray(new Users[0]);
 } finally {
 em.close();
 }
 }
}
