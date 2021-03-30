package apresentacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaDES {
	public static void main(String[] args) throws Exception {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		String texto = "";
		String senha = "";
		String criptograma = "";
		String opcao = "";
		
		// Entrada de dados
		System.out.print("Digite <E> para encriptar, <D> para decriptar: ");
		opcao = leitor.readLine();
		
		// Processamento
		if(opcao.equalsIgnoreCase("E")) {
			System.out.print("Digitre o texto aberto: ");
			texto = leitor.readLine();
			
			System.out.print("Digite a senha: ");
			senha = leitor.readLine();
			
			criptograma = encriptar(texto, senha);
			
			System.out.println(criptograma);			
		} else if (opcao.equalsIgnoreCase("D")) {
			System.out.print("Digite o criptograma: ");
			criptograma = leitor.readLine();
			
			System.out.print("Digite a senha: ");
			senha = leitor.readLine();
			
			texto = decriptar(criptograma, senha);
			
			System.out.println(texto);					
		}		
	}
	
	private static String encriptar(String texto, String senha) throws Exception {
		SecretKey objChaveSecreta = new SecretKeySpec(senha.getBytes(), "DES");
		Cipher cifra = Cipher.getInstance("DES");
		
		cifra.init(Cipher.ENCRYPT_MODE, objChaveSecreta);
		byte[] arrayDeBytes = cifra.doFinal(texto.getBytes());
		
		return Base64.getEncoder().encodeToString(arrayDeBytes);		
	}
	
	private static String decriptar(String criptograma, String senha) throws Exception {
		SecretKey objChaveSecreta = new SecretKeySpec(senha.getBytes(), "DES");
		Cipher cifra = Cipher.getInstance("DES");
		
		cifra.init(Cipher.DECRYPT_MODE, objChaveSecreta);
		byte[] arrayDeBytes = cifra.doFinal(Base64.getDecoder().decode(criptograma));
		
		return new String(arrayDeBytes);
	}
	
	// Para tornar o criptograma 3DES é só mudar de "DES" para "DESede";
	
}
