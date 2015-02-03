package iv;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;
import java.util.List;

@Path("/movie")
public class RatingRest {
	static String username = "root";
	static String password = "root";
    

	public static void main(String[] args){
		System.out.println(new RatingRest().getRatingInfo(1,122));
	}

	@GET
    @Path("/{id}")
    @Produces("application/json")
    public Rating getRatingInfo(@PathParam("id") int userid, int movieid) {
		
        	try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ratings",username,password);
			
			Statement stmt = con.createStatement();
    			ResultSet rs = stmt.executeQuery("select userid, movieid, ratings, timestamp from ratings where userid="+userid+" and movieid="+movieid);
			if (!rs.next())
				return null;
			
			Rating result = new Rating();
			result.setUserId(rs.getInt("userid"));
			result.setMovieId(rs.getInt("movieid"));
        		result.setRate(rs.getInt("ratings"));
        		result.setTimestamp(rs.getInt("timestamp"));
						
			con.close();
			return result;
		}catch(Exception e){
			System.out.println(e.getMessage());	
			return null;
		}
    }
}
