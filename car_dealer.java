package billingproject;
import java.util.Scanner;
public class CarUsage {
	public static void main(String [] args) {
		String[] model = {"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Highline","Taigun Topline"};
		double[] cost = {8.70,10.09,11.05,13.08,14.89,15.42,17.71};
		for(int i=0;i<7;i++) {
			System.out.println(model[i]+"  ==>  "+cost[i]);
		}
		System.out.println();
		//Taxes
		int RTO = 113990;
		int insurance = 47300;
		int tcs = 11000;
		int accessory = 15000;
		
		//finding index of inserted option
		Scanner sc = new Scanner(System.in);
		System.out.print("Select car model:");
		String name = sc.nextLine();
		
		int index=-1;
		for(int i=0;i<7;i++) {
			if(name.equals(model[i])) {
				index=i;
				break;
			}
		}
        boolean isInsuranceTaken=false;
		//checking insurance is taken or not
		System.out.print("Do you need Insurance:");
		String in = sc.nextLine();
		if(in.equals("yes")) {
			isInsuranceTaken=true;
		}
		boolean isAccessoryTaken=false;
		//checking accessories are taken or not
		System.out.print("Do you need Additional Accessories:");
		String ac = sc.nextLine();
		if(ac.equals("yes")) {
			isAccessoryTaken=true;
		}
		// Discount
		
		System.out.print("Dealer discount: ");
		String percent = sc.next();
		int totalcost;
		int discountAmt;
		double temp;
		if(isInsuranceTaken==true || isAccessoryTaken==true) {
			if(percent.contains("%")) {
			int Percent = Integer.parseInt(percent.replace("%", ""));
			temp = Percent*0.01;
			discountAmt = (int)(((int)Math.round(cost[index]*100000))*temp);
			}
			else
				discountAmt = Integer.parseInt(percent);
		}
		else {
			System.out.println("any one of the additional features have to be added");
			discountAmt = 0;
		}
		// calculating
	
	
		if(isInsuranceTaken==false) {
			insurance = 0;
		}
		if(isAccessoryTaken==false) {
			accessory = 0;
		}
		if(discountAmt>30000) {
			System.out.println("Maximum discount to be applied should not cross 30,000 and only apply 30,0000 discount");
		}
		else {
		totalcost = (int)Math.round(cost[index]*100000) + RTO + insurance + tcs + accessory - discountAmt;
		System.out.println("Total cost "+totalcost);
		}
	}
}
