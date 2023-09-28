/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/

import java.util.ArrayList;
import java.util.List;


public class VeryBasicTokenizer {
	private char[] input;
	private int index;
	
	public VeryBasicTokenizer(String str) {
		input = str.toCharArray();
		index = 0;
	}
	
	//Avanca para o proximo caractere e retorna seu valor.
	//Ou retorna \o quando chegou no final da string
	
	private char getNextChar() {
		if (index >= input.length) {return '\0';}
		return input[index++];
	}
	
	//separa a string em tokens e retorna uma lista de strings,
	//sendo que cada string e um token reconhecido pelo metodo
	public List<String> tokenize(){
		List<String > tokens = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		char currChar = getNextChar();
		
		boolean isTokenizing = true;
		while(isTokenizing) {
			//ignora os espacos em branco
			while (Character.isWhitespace(currChar))
				currChar = getNextChar();
			
			if (Character.isDigit(currChar)) {//Reconhece numero (inteiro/decimal)
				sb.setLength(0);
				boolean ParteDecimal = false;
				while (Character.isDigit(currChar) || (currChar == '.' && ParteDecimal==false)) {
					if(currChar == '.') {
						ParteDecimal = true;
					}
					sb.append(currChar);
					currChar = getNextChar();
				}
				tokens.add(sb.toString());
			} else if (currChar == '+') {//Reconhece simbolo +
			  tokens.add("+");
			  currChar = getNextChar();
			} else if (currChar =='*') {//Reconhece simbolo *
				tokens.add("*");
				currChar = getNextChar();
			} else if (currChar =='-') {//Reconhece simbolo -
				tokens.add("-");
				currChar = getNextChar();
			} else if (currChar =='/') {//Reconhece simbolo /
				tokens.add("/");
				currChar = getNextChar();
			} else if (currChar == '(') {//Reconhece simbolo (
				  tokens.add("(");
				  currChar = getNextChar();
			} else if (currChar == ')') {//Reconhece simbolo )
				  tokens.add(")");
				  currChar = getNextChar();
			} else if (currChar == '\0') {
			  isTokenizing = false;
			
			}else {
				System.out.println("token não reconhecido: "+ currChar);
				tokens.add("F");
				isTokenizing = false;
			}
		}
		return tokens;
	}
	
}
		
	

