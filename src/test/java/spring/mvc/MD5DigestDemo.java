package spring.mvc;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class MD5DigestDemo {
	
	// 取得加密資料
	public static String getEncryptString(String input) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] result = md5.digest(input.getBytes());
		// System.out.println("加密資料: " + result);
		// 透過 Arrays.toString() 印出 byte[]
		// System.out.println("加密資料: " + Arrays.toString(result));
		// 印出 16 進位字串格式(32 個字不足補0), %X 表示 16 進位
		String output = String.format("%032X", new BigInteger(result));
		// System.out.println("加密資料 16 進位:" + output);
		return output;
	}
	
	public static void main(String[] args) throws Exception {
		// Encryment (private key)
		String input = "1234";
		String output = getEncryptString(input);
		System.out.println("資料庫密碼欄位存放: " + output);

		// 登入
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入密碼: ");
		String pwd = scanner.next();
		String pwdMD5 = getEncryptString(pwd);
		System.out.println("使用者所輸入的密碼加密後的結果: " + pwdMD5);
		
		// 比對
		if(output.equals(pwdMD5)) {
			System.out.println("登入成功");
		} else {
			System.out.println("登入失敗");
		}
		
		
		
	}
}
