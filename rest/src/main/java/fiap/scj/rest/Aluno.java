package fiap.scj.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno {
	private Integer ra;
	private String nome;
	
	
	public Aluno() {
		super();
	}
	public Aluno(Integer ra, String nome) {
		super();
		this.ra = ra;
		this.nome = nome;
	}
	public Integer getRa() {
		return ra;
	}
	public void setRa(Integer ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
