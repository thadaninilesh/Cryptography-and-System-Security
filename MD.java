import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public abstract class MD extends MessageDigestSpi {

	
	 public static void main(String[] args) throws NoSuchAlgorithmException {
		 String input = null;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the input: ");
		 input = sc.next();
	     System.out.println("MD5 encrypted message: "+getMD5(input));
	     sc.close();
	     }
	 
	public static String getMD5(String input) {
        byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
        	 MessageDigest md = MessageDigest.getInstance("MD5");
             md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
                // to show all the 16 rounds
                //System.out.print("Round "+(i+1)+": ");
                //System.out.println(new String(str));
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
