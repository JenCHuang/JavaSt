import java.util.Scanner;

public class TGame {

	public static int[] arange(int a) {
		int[] arr = new int[a];
		for (int i=0;i<a;i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// Given an answer
		int n=10;
		int[] arrt = TGame.arange(n);
		String ans = "";
		for (int i=0; i<4; i++) {
			int r = (int)(Math.random()*n);
			ans = String.join("", ans, ""+arrt[r]);
			arrt[r]=arrt[n-1];
			n--;
		}
		// Print out the answer
//		System.out.println("Ans.: "+ans);
		
		// Begin a Game
		System.out.println("Game Start! Please input 4 Not-Repeating numbers.");
		int oa = 0;
		int ob = 0;
		int idx= 0;
		int tnum = 1;
		int check1 = 0;
		int check2 = 0;
		String cword = "";
		String teststr = "0123456789";
		do {
			// Player's Input
			System.out.printf("Round  %d: ",tnum);
			Scanner s = new Scanner(System.in);
			String inp = s.next();
			// Check input
			if (inp.equals("exit")) {
				System.out.println("Exit Game!");
				break;
			}
			tnum++;
			
			if (inp.length() != 4) {
				System.out.println("Input should be 4 Not-Repeating numbers.");
				continue;
			}
			
			String[] inpa = inp.split("");
			oa=0;
			ob=0;
			check1=0;
			check2=0;
			cword="";
			// Begin the game!
			for (int i=0; i<4;i++) {
				if (teststr.indexOf(inpa[i]) == -1) {
					check1++;
				} 
				
				if (cword.indexOf(inpa[i]) != -1) {
					check2++;
				}
				cword = cword + inpa[i];
				
				idx = ans.indexOf(inpa[i]);
				if (idx==i) {
					oa++;
				}else if (idx != -1) {
					ob++;
				}
			}
			if (check1 != 0) {
				System.out.println("Your input contained nonnumeric character.");
				continue;
			} else if (check2 !=0) {
				System.out.println("Your input contained repeating numbers.");
				continue;
			}
			
			System.out.println(" "+oa+"A"+ob+"B");
			if (oa == 4) {
				System.out.println("Bingo!!");
				break;
			}
		}
		while (tnum<=15);
		System.out.println("Game End");
		
	}

}
