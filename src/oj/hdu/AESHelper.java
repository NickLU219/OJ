package oj.hdu;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by fh on 2016/12/6.
 */

public class AESHelper {
	private static final String AES = "AES";
	private static final String AES_KEY = "0123456789abcdef";
	private static final SecretKeySpec SECRET_KEY_SPEC = new SecretKeySpec(AES_KEY.getBytes(), "AES");

	/**
	 * 鍔犲瘑
	 *
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC);
			byte[] encrypted = cipher.doFinal(str.getBytes());
			// 姝ゅ浣跨敤BASE64鍋氳浆鐮佸姛鑳斤紝鍚屾椂鑳借捣鍒�2娆″姞瀵嗙殑浣滅敤銆�
			return Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			return str;
		}
	}

	/**
	 * 瑙ｅ瘑
	 *
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC);
			// 鍏堢敤base64瑙ｅ瘑
			byte[] encrypted = Base64.getDecoder().decode(str.getBytes());
			byte[] original = cipher.doFinal(encrypted);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception e) {
			return str;
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(encrypt("fh-zhangenlai"));
		System.out.println(Base64.getEncoder().encodeToString(encrypt("fh-zhangenlai").getBytes()));
		System.out.println(Base64.getEncoder().encodeToString(URLEncoder.encode("123", "UTF-8").getBytes()));
		System.out.println(Base64.getEncoder().encodeToString(URLEncoder.encode("寮犱笁", "UTF-8").getBytes()));
	}
}
