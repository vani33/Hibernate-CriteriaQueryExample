
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

 
	public class EmployeeTest {
		public static void main(String arg[]) throws Exception {
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory(); 
			Session session = factory.openSession();
				 
				Transaction t = session.beginTransaction();
				
				// criteria example 1
				/*Criteria criteria=session.createCriteria(Employee.class);
				List<Employee> employees=criteria.list();
                 for(Employee emp : employees){
                	 System.out.println("EmployeeName:" + emp.getEmpName() + " " + "EmployeeSalary:" + emp.getSalary());
                 }*/
				
				
                 
               //criteria example 2
 	/*			Criteria criteria=session.createCriteria(Employee.class);
 	
 				criteria.add(Restrictions.like("empName", "V%"));
 				
 				List<Employee> employees=criteria.list();
                  for(Employee emp : employees){
                 	 System.out.println(emp.getEmpName() + " " + emp.getSalary());
                  }*/
				
				
				
				
				
				
                  
               // criteria example 3
   				/*Criteria criteria=session.createCriteria(Employee.class);
   	
   				criteria.add(Restrictions.gt("salary", 10000.0));
   				
   				List<Employee> employees=criteria.list();
                    for(Employee emp : employees){
                   	 System.out.println(emp.getEmpName() + " " + emp.getSalary());
                    }*/
				
				//example 5
				/*Criteria criteria=session.createCriteria(Employee.class);
			   	
                    Criterion salary = Restrictions.eq("salary", 10000.0);
                    Criterion name =   Restrictions.like("empName", "K%");

                    // To get records matching with OR conditions
                    LogicalExpression andExp = Restrictions.and(salary, name);
                    criteria.add( andExp );
                    LogicalExpression orExp = Restrictions.or(salary, name);
                    criteria.add( orExp );
                    List<Employee> employees=criteria.list();
                    for(Employee emp : employees){
                   	 System.out.println(emp.getEmpName() + " " + emp.getSalary());
                    }
*/
				
				// criteria example 4 - Result Set Paging
       				/*Criteria criteria=session.createCriteria(Employee.class);
       	
       				
       				criteria.setFirstResult(0);//if we want from 1st row then give 0.
       				criteria.setMaxResults(3);//max number of rows to be printed.

       				List<Employee> employees=criteria.list();
                    for(Employee emp : employees){
                   	 System.out.println(emp.getEmpName() + " " + emp.getSalary());
                    }*/
                    
                    
                                      
                    
                 // criteria example 5  - Sorting Query Results
       				/*Criteria criteria=session.createCriteria(Employee.class);
       	
       				
       				//criteria.addOrder(Order.asc("salary"));
       				criteria.addOrder(Order.desc("salary"));
       				

       				List<Employee> employees=criteria.list();
                    for(Employee emp : employees){
                   	 System.out.println(emp.getEmpName() + " " + emp.getSalary());
                    }
*/                    
                   //example 6 :- Projection 
                    Criteria crit = session.createCriteria(Employee.class);
                    ProjectionList projList = Projections.projectionList();
                    projList.add(Projections.property("empName"));
                    projList.add(Projections.property("salary"));
                    crit.setProjection(projList);
                  // crit.addOrder(Order.asc("salary"));
                    List<Object[]> results = crit.list();
                    for(Object[] row : results){
                        System.out.println(row[0].toString());
                        System.out.println(row[1].toString()); 
                        //System.out.println(row[2].toString());
                       
                        
                        }
                    
                    // criteria example 6 - Aggregations
                    
                   // Criteria criteria = session.createCriteria(Employee.class);
                    
                 // To get total row count.
                    //criteria.setProjection(Projections.rowCount());

                    // To get average of a property.
                    //criteria.setProjection(Projections.avg("salary"));

                    // To get distinct count of a property.
                   // criteria.setProjection(Projections.countDistinct("firstName"));

                    // To get maximum of a property.
                    //criteria.setProjection(Projections.max("salary"));

                    // To get minimum of a property.
                    //criteria.setProjection(Projections.min("salary"));

                    // To get sum of a property.
                    /*criteria.setProjection(Projections.sum("salary"));
                    List<String> totalSalary = criteria.list();

                    System.out.println(totalSalary);
                    
                    
                    
                    // more than one projection 
                    
                    
                    Criteria crit1 = session.createCriteria(Employee.class);
                    ProjectionList projList1 = Projections.projectionList();
                    projList1.add(Projections.max("salary"));
                    projList1.add(Projections.min("salary"));
                    projList1.add(Projections.avg("salary"));
                    projList1.add(Projections.countDistinct("salary"));
                    crit1.setProjection(projList1);
                    List<Object[]> results1 = crit1.list();
                    for(Object[] row : results1){
                    System.out.println(row[0].toString());
                    System.out.println(row[1].toString());
                    System.out.println(row[2].toString());
                    System.out.println(row[3].toString());
                    
                    }*/
				    factory.close();  
				    session.close(); 
		}
	}
