import java.io.*;
import java.util.*;
public class DoubleTransposition {
	static String text=null;
	
	public static void main(String args[]){
		int k=0,count=0,rows=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a plain text: ");
		text = sc.next();
		int length = text.length();
		int columns = 5;
		if(length%columns>0){
			rows = 1;
		}
		rows = (length/columns) + rows;		
		int a[] = new int[]{3,4,0,2,1};
		char temp[] = new char[length];
		temp = text.toCharArray();
		char str[][] = new char[rows][columns];
		char t[][] = new char[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				str[i][j]='*';
				t[i][j]='*';
			}
		}
		
		loop:
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				str[i][j] = temp[k++];
				count++;
				if(count==length){
					break loop;
				}
			}
		}
		
		for(int i=0; i<columns; i++){
			int n=a[i];
			for(int j=0;j<rows;j++){
				t[j][n] = str[j][i];
			}
		}
		k=0;
		String middle="";
		for(int i=0;i<columns;i++){
			for(int j=0;j<rows;j++){
				middle += t[j][i];
			}
		}
		
		System.out.println("Middle text: "+middle);
		
		temp = middle.toCharArray();
		k=0;
		loop:
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					str[i][j] = temp[k++];
					count++;
					if(count==length){
						break loop;
					}
				}
			}
		for(int i=0; i<columns; i++){
			int n=a[i];
			for(int j=0;j<rows;j++){
				t[j][n] = str[j][i];
			}
		}
		
		String cipher="";
		for(int i=0;i<columns;i++){
			for(int j=0;j<rows;j++){
				cipher += t[j][i];
			}
		}
		
		System.out.println("Cipher text: "+cipher);
		
		
		
		
		
		
		
		
		//decryption
		temp = cipher.toCharArray();
		k=0;
		loop:
			for(int i=0; i<columns; i++){
				for(int j=0; j<rows; j++){
					str[j][i] = temp[k++];
					count++;
					if(count==length){
						break loop;i
					}
				}
			}
		for(int i=0; i<columns; i++){
			int n=i;//a[i];
			int z=a[i];
			for(int j=0;j<rows;j++){
				t[j][n] = str[j][z];
			}
		}
		
		String plain="";
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				plain += t[i][j];
			}
		}
		
		System.out.println(plain);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
