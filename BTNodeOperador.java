/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/

public class BTNodeOperador extends BTNode{
	
	public BTNodeOperador(char data) {
		super(data);
	}
	
	
	
	@Override
	public float visitar() {
		float valorEsq = this.getLeft().visitar();
		float valorDir = this.getRight().visitar();
		
		switch ((char)getData()) {
		case '+':
			return (valorEsq + valorDir);
		case '-':
			return valorEsq - valorDir;
		case '*': 
			return valorEsq * valorDir;
		case '/':
			if (valorDir != 0) {
				return valorEsq / valorDir;
			}
			else {
				System.out.println("Divisao por zero!");
				return Float.NaN;
			}

		}
		return Float.NaN;
	}
}
