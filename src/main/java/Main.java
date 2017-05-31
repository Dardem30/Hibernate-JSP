import by.DAO.DAOImple;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

/**
 * Created by УВД on 29.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        DAOImple daoImple=new DAOImple();
        System.out.println(daoImple.getHeroById(1).getName());
    }
}