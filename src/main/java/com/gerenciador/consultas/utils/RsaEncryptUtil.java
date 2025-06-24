/*
 * package com.gerenciador.consultas.utils;
 * 
 * import java.nio.charset.StandardCharsets; import java.nio.file.Files; import
 * java.security.PublicKey; import java.security.spec.X509EncodedKeySpec; import
 * java.util.Base64;
 * 
 * import javax.crypto.Cipher;
 * 
 * import org.springframework.cglib.core.KeyFactory;
 * 
 * 
 * import jakarta.persistence.criteria.Path;
 * 
 * public class RsaEncryptUtil {
 * 
 * public static String encryptWithPublicKey(String json, String publicKeyPath)
 * throws Exception { String publicKeyContent =
 * Files.readString(Path.of(publicKeyPath))
 * .replace("-----BEGIN PUBLIC KEY-----", "")
 * .replace("-----END PUBLIC KEY-----", "") .replaceAll("\\s", "");
 * 
 * byte[] decoded = Base64.getDecoder().decode(publicKeyContent);
 * X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded); PublicKey
 * publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
 * 
 * Cipher cipher = Cipher.getInstance("RSA"); cipher.init(Cipher.ENCRYPT_MODE,
 * publicKey); byte[] encryptedBytes =
 * cipher.doFinal(json.getBytes(StandardCharsets.UTF_8)); return
 * Base64.getEncoder().encodeToString(encryptedBytes); } }
 */