/*
TURMA 04G11
NOME: ERIK SAMUEL VIANA HSU							TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO 						TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA		TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA					TIA: 32210744
*/

public class BTNodeOperando extends BTNode{
	private float valor;
	
	public BTNodeOperando(float valor) {
		super(' ');
		this.valor = valor;
	}
	
	@Override
	public float visitar() {
		return valor;
	}
}