/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/
package apl1;

public class BTNodeOperador extends BTNode{
	private char operador;
	
	public BTNodeOperador(char operador) {
		super();
		this.operador = operador;
	}
	
	public BTNodeOperador(BTNode parent, char operador) {
		super(parent);
		this.operador = operador;
	}
	
	public void setOperador(char operador) {
		this.operador = operador;
	}
	
	@Override
	public float visitar() {
		return operador;
	}
}
