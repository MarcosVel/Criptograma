package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class CriptografiaRSA {
	public static void main(String[] args) {
		// Declaração de cariáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		String chavePublica = "";
		String chaveSecreta = "";
		String textoAberto = "";
		String criptograma = "";
		
		// Processamento
		try {
			KeyPair objParDeChaves = gerarParDeChaves();
			System.out.println("Chave pública:" + new String (Base64.getEncoder().encode(objParDeChaves.getPublic().getEncoded()), "UTF-8"));
			System.out.println("Chave secreta:" + new String (Base64.getEncoder().encode(objParDeChaves.getPrivate().getEncoded()), "UTF-8"));
		
			System.out.println("Digite o texto aberto: ");
			textoAberto = leitor.readLine();
			
			System.out.println("Digite a chave: ");
			chavePublica = leitor.readLine();
			
			criptograma = encriptar(textoAberto, getChavePublica(chavePublica));
			System.out.println(criptograma);
		} catch (Exception erro) {
			System.out.println(erro);
		}	
			
	}
	
	private static KeyPair gerarParDeChaves() throws Exception {
		KeyPairGenerator geradorDeChaves = KeyPairGenerator.getInstance("RSA");
		geradorDeChaves.initialize(1024);
		
		return geradorDeChaves.generateKeyPair();		
	}
	
	private static PublicKey getChavePublica(String chavePublica) throws Exception {
		EncodedKeySpec especificacaoChavePublica = new X509EncodedKeySpec(Base64.getDecoder().decode(chavePublica));
		
		return KeyFactory.getInstance("RSA").generatePublic(especificacaoChavePublica);
	}
	
	private static String encriptar(String texto, Key chave) throws Exception {
		Cipher cifra = Cipher.getInstance("RSA");
		cifra.init(Cipher.ENCRYPT_MODE, chave);
		
		return Base64.getEncoder().encodeToString(cifra.doFinal(texto.getBytes("UTF-8")));
	}

}
