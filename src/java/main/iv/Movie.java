package iv;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Movie {

    private int id;
    private String title;

    @XmlElement(name="genres")
    private List<String> genres = new ArrayList<String>();

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public List<String> getGenres () {
        return genres;
    }
}
