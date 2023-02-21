import java.util.Hashtable;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/mark")
public class Database {
	private Hashtable<String,Integer> table = new Hashtable<String,Integer>();
	
	@POST
	@Path("{student}+{mark}")
	public String addRecord(@PathParam("student") String student, @PathParam("mark") String mark) {
	// Add a record using id as key and mark as value
		table.put(student, Integer.valueOf(mark));
		System.out.println("Student: " + student);
		System.out.println("Mark: " + mark);
		return "";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMark(@QueryParam("student") String student) {
	// Retrieve a record using id as key
		if(table.contains(student)) {
			System.out.println(student + " " + table.get(student));
			return Integer.toString(table.get(student));
		}
		System.out.println("Student not exists");
		return "";
	}
	
	public String updateRecord(. . .) {
	// Update a record using id as key and mark as value
	}
}
