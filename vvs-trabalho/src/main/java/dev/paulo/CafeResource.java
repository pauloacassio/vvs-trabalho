package dev.paulo;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cafe")
@Transactional
// Classe para configuração dos endpoints de café
public class CafeResource {
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    // end point para salvar um café
    public Cafe save(@FormParam("nome") String nome, @FormParam("nota") int nota,  @FormParam("tipo") String tipo, @FormParam("favorito") boolean favorito, @FormParam("cafeteria_id") Long cafeteria_id) {
        Cafe c = new Cafe();
        c.setNome(nome);
        c.setNota(nota);
        c.setTipo(tipo);
        c.setFavorito(favorito);
        
        // inserindo cafe na cafeteria
        Cafeteria cafeteria = Cafeteria.findById(cafeteria_id);
        if (cafeteria == null)
           throw new BadRequestException("Cafeteria not found");
  
        cafeteria.addCafe(c);
        c.setCafeteria(cafeteria);
        
        c.persist();
        return c;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para listar os cafés
    public List<Cafe> list() {
        return Cafe.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para listar o café por ID
    public Cafe list(@PathParam("id") Long id) {
        return Cafe.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // Ent point para deletar um café pelo ID
    public Cafe delete(@PathParam("id") Long id) {
        Cafe c = Cafe.findById(id);
        c.delete();
        return c;
    }

    @PUT
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para editar um café pelo ID
    public Cafe edit(@FormParam("id") Long id, @FormParam("nome") String nome, @FormParam("nota") int nota,  @FormParam("tipo") String tipo, @FormParam("favorito") boolean favorito) {
        Cafe c = Cafe.findById(id);
        c.setNome(nome);
        c.setNota(nota);
        c.setTipo(tipo);
        c.setFavorito(favorito);
        return c;
    }

    @PATCH
    @Path("/favoritar")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para favoritar um café
    public Cafe favoritarDesfavoritar(@FormParam("id") Long id, @FormParam("favorito") boolean favorito) {
        Cafe c = Cafe.findById(id);
        c.setFavorito(favorito);
        return c;
    }
}