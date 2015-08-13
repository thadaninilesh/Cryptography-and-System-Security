import java.math.BigInteger;
import java.util.*;

public class RSA {

    public static void main(String[] args) {
        int p=0,q=0;
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 large prime numbers: ");
        p=sc.nextInt();
        q=sc.nextInt();
        int n = p*q;
        int fin = (p-1) * (q-1);
        System.out.println("Enter the public key: ");
        int e = sc.nextInt();
        int d = inverse(e,fin);
        System.out.println("Private key "+d);
        System.out.println("Enter a plain integer digit: ");
        int pt = sc.nextInt();
        int enc = encrypt(pt,e,n);
        System.out.println("Encrypted value of "+pt+" is "+enc);
        System.out.println("Do you want to decrypt: ");
        String ans = sc.next();
        BigInteger dec = new BigInteger("0");
        BigInteger a = BigInteger.valueOf(enc);
        BigInteger b = BigInteger.valueOf(d);
        BigInteger c = BigInteger.valueOf(n);

        if(ans.equalsIgnoreCase("Y")){
            dec = decrypt(a,b,c);
        }
        else{
            System.exit(0);
        }
        System.out.println("The decrypted text is "+dec);
    }
    
    public static BigInteger decrypt(BigInteger enc,BigInteger d,BigInteger n){
        BigInteger mul,dec;
        dec = enc.modPow(d,n);
        return dec;
    }
    
    public static int encrypt(int pt,int e,int n){
        int enc=0;
        enc = (int) (Math.pow(pt,e)%n);
        return enc;
    }
    
    public static int inverse(int e,int fin){
		int r1=fin,r2=e,q,r,t1=0,t2=1,t,v=0;
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
			System.out.println("No multiplicative inverse"); }
		else if(r1==1){
			//finds the original text
			if(t1<0){
				v = (t1 + fin); //if t1 is negative, it makes it positive.
			}
			else{
				v = t1;
			}	
		}
		return v;
	}
}
