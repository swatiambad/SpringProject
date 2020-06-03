import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class client {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Country.class);
	/*cfg.addAnnotatedClass(Student.class);*/
	SessionFactory sessionfactory=cfg.buildSessionFactory();
	Session session=sessionfactory.openSession();
	Transaction tx=session.beginTransaction();
	
	
	/*Student student=session.load(Student.class, 15);
	System.out.println(student.getAge());
	System.out.println(student.getContact());
	System.out.println(student.getName());
	System.out.println(student.getPassword());
	
	
	Student stu=new Student();
	stu.setId(2);
	stu.setName("gauri");
	stu.setAge("25");
	stu.setContact("767");
	stu.setPassword("88vvgff");
	session.save(stu);*/
	
	Country country=new Country();
	country.setCid(3);
	country.setCname("china");
	session.save(country);
	tx.commit();
	
	
}
}
