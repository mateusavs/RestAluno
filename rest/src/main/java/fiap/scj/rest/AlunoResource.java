package fiap.scj.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/aluno")
public class AlunoResource {
	
	private static List<Aluno> listaAlunos = new ArrayList<Aluno>();
	static {
		
		listaAlunos.add(new Aluno(123, "Humberto"));
		listaAlunos.add(new Aluno(124, "Doisberto"));
		listaAlunos.add(new Aluno(125, "Tresberto"));
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Aluno> getAllAlunos(){
		return listaAlunos;
	}
	
	@GET
	@Path("/{ra}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Aluno findAluno(
			@PathParam(value= "ra") Integer ra){
		for(Aluno aluno : listaAlunos) {
			if(aluno.getRa().equals(ra)) {
				return aluno;
			}
		}
		return null;
	}
	
	@GET
	@Path("/query")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Aluno buscaAluno(
			@QueryParam(value= "ra") Integer ra){
		for(Aluno aluno : listaAlunos) {
			if(aluno.getRa().equals(ra)) {
				return aluno;
			}
		}
		return null;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAluno(Aluno aluno) throws Exception{
		listaAlunos.add(aluno);
		return Response
				.created(
				new URI("http://localhost:8080/rest/aluno/" + aluno.getRa()))
				.build();
		
	}

	
	
	
}
