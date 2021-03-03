package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vigenere {
	public static void main(String[] args) {
		// Declaracao de variaveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		String opcao = "";
		String texto = "";
		String senha = "";
		String resultado = "";
		
		try {
			do {
				// Entrada de dados
				System.out.print("Digite C para criptografar, ou D para decriptografar, ou S para sair: ");
				opcao = leitor.readLine();
				
				System.out.print("Digite o texto: ");
				texto = leitor.readLine();
				
				System.out.print("Digite a senha: ");
				senha = leitor.readLine();
				
				// Processamento
				if (opcao.equalsIgnoreCase("C")) {
					resultado = encrypt(senha, texto);
				} else if (opcao.equalsIgnoreCase("D")) {
					resultado = decrypt(senha, texto);
				} else {
					resultado = "";
				}
				
				// Saída de dados
				System.out.println(resultado);
				
			} while (! opcao.equalsIgnoreCase("S"));			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static String encrypt(String senha, String texto) {
		String criptograma = "";
		
		for (int i = 0; i < texto.length(); i++) {
			int caractereResultadoDoXOR = (int) (texto.toCharArray()[i] ^ senha.toCharArray()[i % senha.length()]);
			String hexaDecimal = Integer.toHexString(caractereResultadoDoXOR);
			
			criptograma += (hexaDecimal.length() == 1 ? "0" : "") + hexaDecimal;
		}
		
		return criptograma;
	}
	
	private static String decrypt(String senha, String texto) {
		String mensagem = "";
		int contadorSenha = 0;
		
		for (int i = 0; i < texto.length(); i+=2) {
			String hexaDecimal = texto.substring(i, i + 2);
			char caractereResultadoDoXOR = (char) (Integer.parseInt(hexaDecimal, 16) ^ senha.toCharArray()[contadorSenha % senha.length()]);
			
			mensagem += caractereResultadoDoXOR;
			
			contadorSenha++;
		}
		
		return mensagem;
	}
	
}
