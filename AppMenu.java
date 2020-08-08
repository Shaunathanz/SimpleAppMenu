/**
 * @author shaungraham
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class AppMenu 
{
	public static enum State {RUNNING, EXIT};
	public static State state;
	
	public static void main(String[] args)
	{
		state = State.RUNNING;
		do
		{
			menu();
		} while (state != State.EXIT);
	}
	
	public static void menu()
	{
		Scanner scan = new Scanner(System.in);
		int input, exitValue;
		ArrayList<String> options = new ArrayList<String>();
		
		//ADD OPTIONS HERE//////////////////////
		options.add(new String("Lab 6"));
		options.add(new String("Exercise 6"));
		////////////////////////////////////////
		
		do
		{
			exitValue = (options.size() + 1);
			input = 0;
			boolean validInput = false;
			
			do
			{
				//PRESENT OPTIONS			 
				System.out.println("Make a selection:");
				for(int i = 0; i < options.size(); i++)
				{
					System.out.println((i + 1) + ") " + options.get(i));
				}
				System.out.println( (options.size() + 1) + ") Exit");
				
				//GET MENU SELECTION FROM USER
				try
				{
					input = scan.nextInt();
					validInput = true;
				} 
				catch (InputMismatchException e)
				{
					System.out.println("You must enter an integer value");
					scan.next();
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
					scan.next();
				}
			} while (validInput != true);
			
			//EXIT CHECK
			if(input == exitValue)
			{
				state = State.EXIT;
				System.out.println("Bye!");
				scan.close();
				break;
			}
			
			//EXECUTE MENU SELECTION
			switch(input)
			{
				case 1:
				{
					new Lab6App();
					break;
				}
				case 2:
				{
					new Exercise6App();
					break;
				}
				default:
				{
					System.out.println("Invalid task selection. Select a program or enter " + exitValue + " to exit the program.");
					break;
				}
			}
		} while(state == State.RUNNING);
	}
}
