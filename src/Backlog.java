
	import java.util.ArrayList;
	import java.util.LinkedList;

	public class Backlog {
	   private String ProjectName;
	   private String ProjectLength;
	    private IssueList issues;


	    public Backlog(String name, String ProjectLength) {
	        this.ProjectName = name;
	        this.ProjectLength = ProjectLength;
	        this.issues = new IssueList();
	    }

	    public boolean addIssue(String Title, double Points){
	        return this.issues.addIssue(new Scrumissues(Title, Points));
	    }


	    public boolean AddToSprint(int issueNumber, LinkedList<Scrumissues>sprint){
	    	Scrumissues checkedIssue = this.issues.findIssue(issueNumber);
	        if(checkedIssue != null){
	            sprint.add(checkedIssue);
	            return true;
	        }
	        System.out.println(issueNumber + " Does Not Exist In The Backlog");
	        return false;
	    }

	    public boolean addToSprint(String title, LinkedList<Scrumissues> sprint){
	    	Scrumissues checkedIssue = this.issues.findIssue(title);
	        if(checkedIssue != null){
	            sprint.add(checkedIssue);
	            return true;
	        }

	        System.out.println("The Issue "+title+" Is Not In The Backlog");
	        return false;

	    }


	//inner Class
	    private class IssueList {
	        private ArrayList<Scrumissues> issues;

	        public IssueList(){
	            this.issues = new ArrayList<Scrumissues>();
	        }

	        public boolean addIssue(Scrumissues issue){
	            if(issues.contains(issue)){
	                return false;
	            }

	            this.issues.add(issue);
	            return true;
	        }

	        private Scrumissues findIssue(String title){
	            for(Scrumissues checkedIssue: this.issues){
	                if(checkedIssue.getTitle().equalsIgnoreCase(title)){
	                return checkedIssue;

	                }
	            }

	            return null;
	        }

	        public Scrumissues findIssue(int issueNumber){
	            int index = issueNumber-1;
	            if((index>0)&&(index<issues.size())){
	                return issues.get(index);
	            }

	            return null;
	        }

	    }
	}


