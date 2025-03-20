package movie;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;

	// Constructor
	public Movie(String title, String actor1, String actor2, String director, int year, int runtimeMinutes){
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
    }

	// Methods
	public String getTitle(){
		return title;
	}

	public String getActor1(){
		return actor1;
	}

	public String getActor2(){
		return actor2;
	}

	public String getDirector() {
		return director;
	}

	public int getYear(){
		return year;
	}

	public int getRuntime(){
		return runtimeMinutes;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setRuntimeMinutes(int runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	// Optional
	public boolean isActorInMovie(String actor){
		if(actor == getActor1() || actor == getActor2()) {
			return true;
		}

		return false;
	}
}
