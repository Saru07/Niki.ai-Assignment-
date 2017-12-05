import java.util.Scanner;
import java.math.BigInteger;

class NikiAssignment2 {

	static BigInteger highest_so_far = new BigInteger("2");
	static BigInteger highest_prev1 = new BigInteger("3");
	static BigInteger highest_prev2 = new BigInteger("2");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long test_cases = sc.nextLong();
		String dummy = sc.nextLine();
		while(test_cases-- != 0) {
			String num = sc.nextLine();
			BigInteger n = new BigInteger(num);
			System.out.println(getCount(n));
		}
	}

		public static BigInteger getCount(BigInteger n) {
			if(n.equals(new BigInteger("0")))
				return new BigInteger("0");
			if(n.equals(new BigInteger("1")))
				return new BigInteger("2");
			if(n.equals(new BigInteger("2")))
				return new BigInteger("3");
			BigInteger result = new BigInteger("0");

			BigInteger loop;
			BigInteger prev1;
			BigInteger prev2;
			
			if(n.compareTo(highest_so_far) == -1) {
				loop = new BigInteger(highest_so_far.add(new BigInteger("1")).toString());
				prev1 = new BigInteger(highest_prev1.toString());
				prev2 = new BigInteger(highest_prev2.toString());
			}

			else {
				loop = new BigInteger("3");
				prev1 = new BigInteger("3");
				prev2 = new BigInteger("2");		
			}
			
			BigInteger modVal = new BigInteger("1000000007");
			BigInteger limit = new BigInteger(n.add(new BigInteger("1")).mod(modVal).toString());
			while(!loop.equals(limit)) {
				result = prev1.add(prev2).mod(modVal);
				prev2 = prev1.mod(modVal);
				prev1 = result.mod(modVal);
				loop = new BigInteger(loop.add(new BigInteger("1")).mod(modVal).toString());
			}
			highest_so_far = new BigInteger(n.toString());
			highest_prev1 = new BigInteger(prev1.toString());
			highest_prev2 = new BigInteger(prev2.toString());
			return result;
		}
}