
public class CalcEngine {

	public static double calc(double investmentAmount, int years, double annualInterestRate){
		double poweredAmount = Math.pow((double)1+ annualInterestRate/(double)100, years);
		return investmentAmount*poweredAmount;
	}
	
	public static void main(String [ ] args){
		//System.out.println(CalcEngine.calc(10000, 3, 3.25));
	}

}
