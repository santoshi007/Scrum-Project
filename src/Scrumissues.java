public class Scrumissues
{
	    private String Title;
	    private double StoryPoints;

	    public Scrumissues(String Title, double Points)
	    {
	        this.Title = Title;
	        this.StoryPoints = Points;

	    }

	    public String getTitle() 
	    {
	        return Title;
	    }


	    @Override
	    public String toString() 
	    {
	        return this.Title+" "+this.StoryPoints;
	    }
}

