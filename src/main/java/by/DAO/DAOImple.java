package by.DAO;

import by.model.HeroesEntity;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by УВД on 29.05.2017.
 */
public class DAOImple {
    public void saveHero(HeroesEntity heroesEntity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(heroesEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<HeroesEntity> getAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<HeroesEntity> list=session.createQuery("from HeroesEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public void update(HeroesEntity heroesEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(heroesEntity);
        session.getTransaction().commit();
        session.close();
    }
public HeroesEntity getHeroById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from HeroesEntity where idhero=:id");
        query.setInteger("id",id);
        HeroesEntity heroesEntity= (HeroesEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return heroesEntity;
}
public void deleteHeroes(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query=session.createQuery("from HeroesEntity where idhero=:id");
    query.setInteger("id",id);
    HeroesEntity heroesEntity= (HeroesEntity) query.uniqueResult();
    session.delete(heroesEntity);
    session.getTransaction().commit();
    session.close();
}
}
