//details package contains class: collect
//calculate package contains class: seperate
//authen package contains class: check


		//collect.java

package details;

import java.util.Scanner;

import authen.check;

public class collect {
	public static String name;
	String dob;
	public static String desig;
	public static int id;
	int phone;
	
	public void getData(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t \t LOGIN DETAILS");
		
		System.out.println("Enter your name: ");
		name = sc.next().toLowerCase();
		
		System.out.println("Enter your id: ");
		id = sc.nextInt();
		
		System.out.println("Enter your DOB: ");
		dob = sc.next();
		
		System.out.println("Enter your phone: ");
		phone = sc.nextInt();
		
		
		System.out.println("Enter your designation(hr / seniordev / juniordev / others) : ");
		desig = sc.next().toLowerCase();

		sc.close();

	}
	public static void main(String args[]) {
		collect c = new collect();
		c.getData();
		check ch = new check();
		ch.data();
		ch.verifying();
	}
	
}




		//check.java

package authen;
import java.util.HashMap;
import calculate.seperate;
import details.collect;


public class check extends collect{
	HashMap<String,Integer> valids = new HashMap<String,Integer>();

	public void data() {
		valids.put("abina", 1);
		valids.put("aishwarya", 2);
		valids.put("thakshika", 3);
		valids.put("rejitha", 4);
		valids.put("mahalakshmi", 5);
	}
	public void verifying() {
		if (!(valids.containsKey(name)) || !(valids.get(name) == id)) {
			System.out.println("Invalid name or id");
		}
		
		else {
			seperate s = new seperate();
			if (collect.desig.equals("hr")) {
				s.hr();
				s.display();
			}
			else if (collect.desig.equals("seniordev")) {
				s.senior_dev();
				s.display();
			}
			else if (collect.desig.equals("juniordev")) {
				s.junior_dev();
				s.display();
			}
			else if(collect.desig.equals("others")) {
				s.other();
				s.display();
			}
			else {
				System.out.println("Invalid input enter (hr / senior dev / junior dev / others) ");
			}
		}
	}
}


		//seperate.java

package calculate;
import details.collect;

public class seperate  extends collect{
	
	double basic,allo,tax,it,medi,hra,lta,net;
	
	public void hr() {
		basic = 40000;
		medi= 4500;
		hra = 20000;
		lta = 28000;
		allo = medi+hra+lta;
		tax = basic*(0.2);
		it = basic*(0.05);
		net = (basic+allo)-(tax+it);
	}
	
	public void senior_dev() {
		basic = 30000;
		medi = 4000;
		hra = 15000;
		lta = 20000;
		allo = medi+hra+lta;
		tax = basic*(0.2);
		it = basic*(0.04);
		net = (basic+allo)-(tax+it);
	}
	
	public void junior_dev() {
		basic = 20000;
		medi = 4000;
		hra = 10000;
		lta = 10000;
		allo = medi+hra+lta;
		tax = basic*(0.1);
		it = basic*(0.03);
		net = (basic+allo)-(tax+it);
	}
	
	public void other() {
		basic = 10000;
		medi = 4000;
		hra = 5000;
		lta = 5000;
		allo = medi+hra+lta;
		tax = basic*(0.1);
		it = basic*(0.2);
		net = (basic+allo)-(tax+it);
	}
	
	public void display(){
		System.out.println();
		System.out.println(); 
		System.out.println("\t \t SALARY SLIP");
		System.out.println();
		System.out.println();
		System.out.println("NAME: "+name.toUpperCase()+"\t \t \t ID:"+id+"\t \t \t DESIGN:"+desig.toUpperCase());
		System.out.println();
		System.out.println();
		System.out.println("BASIC SALARY: \t \t \t \t \t "+basic);
		System.out.println();
		System.out.println("ALLOWANCES: \t");
		System.out.println("MEDICAL ALLOWANCES:\t \t "+medi);
		System.out.println("HOUSE RENT ALLOWANCES: \t	"+hra);
		System.out.println("LEAVE TRAVEL ALLOWANCES:\t"+lta);
		System.out.println("\t \t \t \t_______");
		System.out.println("TOTAL ALLOWANCES: \t \t \t \t"+allo);
		System.out.println();
		System.out.println("GROSS SALARAY: \t \t \t \t \t"+(basic+allo));
		System.out.println();
		System.out.println("NET SALARAY: \t \t  \t \t \t"+net);
		
	}
}
