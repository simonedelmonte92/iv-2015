package iv;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Rating {

	private long timestamp;
	private int userid;
	private int movieid;
	private int rate;
	
	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}

	public void setUserId(int userid){
		this.userid = userid;
	}

	public void setMovieId(int movieid){
		this.movieid = movieid;
	}

	public void setRate(int rate){
		this.rate = rate;
	}

	public int getUserId(){
		return this.userid;
	}

	public int getMovieId(){
		return this.movieid;
	}

	public int getRate(){
		return this.rate;
	}

	public long getTimestamp(){
		return this.timestamp;
	}

	public String toString(){
		return userid+" "+movieid+" "+timestamp+" "+rate;
	}

}
