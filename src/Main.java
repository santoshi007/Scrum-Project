
	//package innerClass.practice;

	import java.util.*;

	public class Main {

	    private static ArrayList<Backlog> backlogs = new ArrayList<Backlog>();
		private static Scanner scanner;

	    public static void main(String[] args) {

	        Backlog backlog = new Backlog("Search Project", "2 years");
	        backlog.addIssue("Install App", 10);
	        backlog.addIssue("Integrate with Cell Phone", 20);
	        backlog.addIssue("Integrate with Education Department", 30);
	        backlog.addIssue("Deal with client's Requrement", 40);


	        backlogs.add(backlog);

	        LinkedList<Scrumissues> sprintBacklog = new LinkedList<Scrumissues>();
	        backlogs.get(0).AddToSprint(3 , sprintBacklog);
	        backlogs.get(0).addToSprint("Deal with client's Requrement", sprintBacklog);

	        startSprint(sprintBacklog);

	    }

	    private static void startSprint(LinkedList<Scrumissues>sprint){
	        scanner = new Scanner(System.in);
	        boolean quit = false;
	        boolean forward = true;

	        ListIterator<Scrumissues> listIterator = sprint.listIterator();
	        if(sprint.size()==0){
	            System.out.println("Please Add Stories To Your Backlog");
	            return;
	        }else{
	            System.out.println("Now Working On "+listIterator.next());
	            printMenu();
	        }
	        while (!quit){
	            int action = scanner.nextInt();
	            scanner.nextLine();

	            switch (action){
	                case 0:
	                    System.out.println("Log out from Tool");
	                    quit = true;
	                    break;

	                case 1:
	                    if(!forward){
	                        if(listIterator.hasNext()){
	                            listIterator.next();
	                        }
	                        forward = true;
	                    }

	                    if(listIterator.hasNext()){
	                        System.out.println("Now Working On "+listIterator.next());
	                    }else{
	                        System.out.println("We Have Reached The End Of The Sprint Backlog");
	                        forward = false;
	                    }

	                    break;

	                case 2:
	                    if(forward){
	                        if(listIterator.hasPrevious()){
	                            listIterator.previous();
	                        }

	                        forward = false;

	                    }

	                    if(listIterator.hasPrevious()){
	                        System.out.println("Now Back To Working On "+listIterator.previous());
	                    }else{
	                        System.out.println("We Are At The start Of The Backlog List");
	                        forward = true;
	                    }
	                    break;

	                case 3:
	                    printSprintBacklog(sprint);
	                    break;

	                case 4:
	                    printMenu();
	                    break;

	                case 5:
	                    if(sprint.size()>0){
	                        listIterator.remove();
	                        if(listIterator.hasNext()){
	                            System.out.println("Now Working On "+listIterator.next());
	                        }else if(listIterator.hasPrevious()){
	                            System.out.println("Back To Working On "+listIterator.previous());
	                        }
	                    }

	                    break;

	            }
	        }

	    }


	    private static void printMenu(){
	        System.out.println("ScrumAsCode actions: \n" +
	                "0 - To Quit \n" +
	                "1 - To Work On Next Item\n" +
	                "2 - To Work On Previous Item \n" +
	                "3 - To Review The Sprint Backlog \n" +
	                "4 - To Go Back To The Menu \n" +
	                "5 - To Remove A Story From The Sprint Backlog");
	    }

	    private static void printSprintBacklog(LinkedList<Scrumissues> sprint){
	        Iterator<Scrumissues> iterator = sprint.iterator();
	        System.out.println("===================================");
	        while (iterator.hasNext()){
	            System.out.println(iterator.next());
	        }
	        System.out.println("===================================");

	    }

	}

