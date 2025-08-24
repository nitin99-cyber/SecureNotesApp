import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class CryptoUtils {
        private static final String ALGO="AES";
        private static final byte[] keyValue="MySecretKey20255".getBytes(); //16 chars
        public static String encrypt(String data) throws
        Exception {
            SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(data.getBytes());
            return
                    Base64.getEncoder().encodeToString(encVal);
        }
        public static String decrypt(String encryptedData)
            throws Exception {
            SecretKeySpec key =new SecretKeySpec(keyValue, ALGO);
            Cipher c=Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue=Base64.getDecoder().decode(encryptedData);
            byte[] decValue = c.doFinal(decodedValue);
            return new String(decValue);

        }
}
