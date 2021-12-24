package model.exception;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;
/*Classe serializable indica que presica de um numero de versão pois podem ser
convertidas em bits e assim trafegar em redes, gravadas em arquivos, etc.
Logo o tipo serializable precisa de um valor padrão de versão no caso valor 1;*/
	public DomainException(String msg) {
		super(msg);
	} //Construtor serve para inicializar/intanciar a excesão criada passando uma mensagem para ela, a msg vai ficar armazenada na excesão.

	
	//As excesoes devem ser tratadas no applicativo e propagadas nas Classe-objetos
	//Para propagar excesoes elas devem ser declaradas nos métodos
	//Para trata com excesoes nas variavés ou logica nas aplicaçoes
}
