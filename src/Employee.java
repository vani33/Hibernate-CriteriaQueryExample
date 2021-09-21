
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Emp22" )
public  class Employee implements Serializable {
	@Id
	@Column(name="EmployeeId", unique = true, nullable = false)
	private int empId;
	@Column(name="EmployeeName")
	private String empName;
	private double salary;
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	private static final long serialVersionUID = 1L;
	public Employee() {
		super();
		}   
	public int getEmpId() { 
		return this.empId; 
		}
	public void setEmpId(int empId) { 
		this.empId = empId; 
		}   
	public String getEmpName() { 
		return this.empName;
		}
	public void setEmpName(String empName) { 
		this.empName = empName; 
		}
}


