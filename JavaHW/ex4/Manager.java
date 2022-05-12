package ex4;

public class Manager extends Employee{
	private long bonus;

	public Manager(int empno, String name, long salary, long bonus) {
		super(empno, name, salary);
    	this.bonus = bonus;
	}
	
	// 經理的薪水為原本的salary加上bonus
	@Override
	public long getSalary() {
		return super.getSalary()+bonus;
	}

}
