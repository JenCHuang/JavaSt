package ex4;

public class TestEmp {

	public static void main(String[] args) {
		Manager mgr = new Manager(101, "Vincent", 50000, 30000);
		System.out.println(mgr.getEmpno());
		System.out.println(mgr.getName());
		System.out.println(mgr.getSalary());
		
	}

}
