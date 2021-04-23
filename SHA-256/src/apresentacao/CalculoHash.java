package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class CalculoHash {
	public static void main(String[] args) {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		String texto = "";
		String hash = "";
		
		try {
			do {
				// Entrada de dados
				System.out.println("Digite um texto: ");
				texto = leitor.readLine();
				
				// Processamento
				hash = calcularHash(texto);
				
				// Saída de dados
				System.out.println(hash);	
			} while (! texto.equalsIgnoreCase("SAIR"));
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	private static String calcularHash(String texto) throws Exception {
		String retorno = "";
		
		MessageDigest objHash = MessageDigest.getInstance("SHA-256");
		objHash.reset();
		objHash.update(texto.getBytes());
		byte[] resultado = objHash.digest();
		
		for (int i = 0; i < resultado.length; i++) {
			String temp = Integer.toHexString(0xFF & resultado[i]);
//			System.out.println(temp + "|");
			retorno += (((temp.length() == 1) ? "0" : "") + temp);
		}
		
		return retorno;
	}
}