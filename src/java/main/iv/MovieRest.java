package iv;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/movie")
public class MovieRest {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Movie getMovieInfo(@PathParam("id") int id) {
        //TODO: get the movie's info from database
        // two ways:
        // 1. use JPA, maybe more complicated to understand at first but very easy code;
        // 2. use plain JDBC, if you love SQL, probably more than enough for what we have to do here.
        //
        // You can see the result of the changes at the address */iv/rest/movie/{id}, for example /iv/rest/movie/43
        Movie example = new Movie();
        example.setId(id);
        example.setTitle("The Lord of The Ring, The Fellowship of the Ring");
        example.getGenres().add("Adventure");
        example.getGenres().add("Fantasy");
        return example;
    }
}
