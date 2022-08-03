package training.hibernate.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Slf4j
@UtilityClass
public class HibernateUtils {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return sessionFactory;
    }
}
