import java.util.*;
public class affine {
	static String pt;
	static int len,k;
	static String encrypt="", decrypt="";
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Text To Be Decrypted: ");
		pt = sc.next();
		len = pt.length(); //determines length of string
		char ch[] = new char[len+1];
		ch = pt.toCharArray(); //converts string to char array
		encrypt = multiplicative(ch,len);
		System.out.println("Cipher Text: "+encrypt); //prints the encrypted cipher key
		System.out.println("Do you want to decrypt? Enter y/n");
		String dec = sc.next();
		if(dec.equalsIgnoreCase("y")){
			ch = encrypt.toCharArray();
			len = encrypt.length();
			decrypt = additiveInverse(len,ch);
			System.out.println("Decrypted Text: "+decrypt);
		}
		else if(dec.equalsIgnoreCase("n")){
			System.exit(0);
		}
		sc.close();
	}
	
	public static String multiplicative(char ch[], int len){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a valid multiplicative key: ");
		k = sc.nextInt();
		//checks whether the supplied key is appropriate or not
		if(k==1 || k==3 || k==5 || k==7 || k==9 ||k== 11 || k==15 || k==17 || k==19 || k==21 || k==23 || k==25){
			for(int i = 0; i<len; i++){
				char x = ch[i];
				int as = x;
				as = x - 97;
				int enc = (as * k)%26;
				int ct = additive(enc,k); //send multiplicative cipher to additive method for each character
				char c = (char)(ct + 65);
				encrypt = encrypt + c; 
			}
			return encrypt; //returns encrypted cipher to main
		}
		else{
			System.out.println("Invalid key!");
		}
		return null;
	}
	
	public static int additive(int enc, int key){
		int ret = (enc + key)%26;
		return ret;
	}
	
	public static String additiveInverse(int len,char ch[]){
		for(int i = 0; i<len; i++){
			int dec = (ch[i] - 65)%26; //subtracts additive
			decrypt = multiplicativeInverse(k,dec);
		}
		return decrypt;
	}
	
	public static String multiplicativeInverse(int k,int dec){
		int r1=26,r2=k,q,r,t1=0,t2=1,t;
		//determines the value of t1 which ultimately finds the original text
		while(r2!=0){
			q = r1/r2;
			r = r1%r2;
			t = t1 - (q * t2);
			r1 = r2;
			r2 = r;
			t1 = t2;
			t2 = t;
		}
		if(r1!=1){
			System.out.println("No multiplicative inverse");
		}
		else if(r1==1){
			//finds the original text
			if(t1<0){
				int v = (t1 + 26); //if t1 is negative, it makes it positive.
				int d = (v * dec)%26;
				char c = (char)(d+96);
				decrypt = decrypt + c;
				//System.out.print(c);
			}
			else{
				int d = (t1 * dec)%26;
				char c = (char)(d+96);
				decrypt = decrypt + c;
				//System.out.print(c);
			}
			
		}
		return decrypt;
	}
}