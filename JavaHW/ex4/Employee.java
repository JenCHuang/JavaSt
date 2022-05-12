package ex4;

public class Employee {
    private int empno;
    private String name;
    private long salary;
    
    public Employee(int empno, String name, long salary) {
    	this.empno = empno;
    	this.name = name;
    	this.salary = salary;
	}
    
	public int getEmpno() {
		return empno;
	}

	public String getName() {
		return name;
	}

	public long getSalary() {
		return salary;
	}

}
