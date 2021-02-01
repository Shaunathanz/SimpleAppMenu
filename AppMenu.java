import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

/**
 * 
 * @author shaungraham
 *
 * Add options to the options array list in the start() function then add the code to execute 
 * in the execute() function below
 */
public final class AppMenu extends Application
{
	public final float VERSION = 1.3f;
	public static ScrollPane sp = new ScrollPane();
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		ArrayList<String> options = new ArrayList<String>();
		
		//ADD OPTIONS HERE//////////////////////
		options.add(new String("Order 66"));
		options.add(new String("Order 67"));
		options.add(new String("Order 68"));
		options.add(new String("Order 69"));
		options.add(new String("..."));
		options.add(new String("New Row!"));
		options.add(new String("n/a"));
		options.add(new String("n/a"));
		options.add(new String("Lots of Text"));
		options.add(new String("Order 66"));
		options.add(new String("Order 67"));
		options.add(new String("Order 68"));
		options.add(new String("Order 69"));
		options.add(new String("..."));
		options.add(new String("New Row!"));
		options.add(new String("n/a"));
		options.add(new String("n/a"));
		options.add(new String("Lots of Text"));
		options.add(new String("Order 66"));
		options.add(new String("Order 67"));
		options.add(new String("Order 68"));
		options.add(new String("Order 69"));
		options.add(new String("..."));
		options.add(new String("New Row!"));
		options.add(new String("n/a"));
		options.add(new String("n/a"));
		options.add(new String("Lots of Text"));
		options.add(new String("Order 66"));
		options.add(new String("Order 67"));
		options.add(new String("Order 68"));
		options.add(new String("Order 69"));
		options.add(new String("..."));
		options.add(new String("New Row!"));
		options.add(new String("n/a"));
		options.add(new String("n/a"));
		options.add(new String("Lots of Text"));
		////////////////////////////////////////
		
		GridPane grid = new GridPane();
		ScrollPane sp2 = new ScrollPane(grid);
		int rowCursor = 0, colCursor = 0;
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
        
		//DISPLAY OPTIONS
		for(int i = 0; i < options.size(); i++)
		{
			if(colCursor > 4)
			{
				++rowCursor;
				colCursor = 0;
			}
			
			final int currentIndex = i;
			Button btn = new Button();
			btn.setMinWidth(100);
	        btn.setText(options.get(i));
	        btn.setOnAction(new EventHandler<ActionEvent>() 
	        {
	            @Override
	            public void handle(ActionEvent event)
	            {
	                execute(currentIndex);
	            }
	        });
	        grid.getChildren().add(btn);
	        GridPane.setRowIndex(btn, rowCursor);
	        GridPane.setColumnIndex(btn, colCursor);
	        ++colCursor;
		}
		grid.getChildren().add(sp);
		GridPane.setRowIndex(sp, rowCursor + 1);
        GridPane.setColumnIndex(sp, 0);
        GridPane.setColumnSpan(sp, 5);
        GridPane.setRowSpan(sp, GridPane.REMAINING);
		
		
		Scene scene = new Scene(sp2, 590, 400);
		primaryStage.setTitle("Simple App Menu ver " + VERSION);
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
	/**
	 * Execute menu selection
	 * @param input
	 */
	public static void execute(int input)
	{	
		String output;
		switch(input)
		{
			case 0:
				output = ("Yes my lord");
				break;
			case 1:
				output = ("Huh?");
				break;
			case 2:
				output = ("...");
				break;
			case 3:
				output = ("( ͡° ͜ʖ ͡°)");
				break;
			case 4:
				output = ("...");
				break;
			case 5:
				output = ("NEW ROW!");
				break;
			case 6:
				output = ("...");
				break;
			case 7:
				output = ("...");
				break;
			case 8:
				output = ("asdasdasd\nasdasdasd\nasdasdasdasd\nasdasdasdasd\nasdasdasdas\nsdfsdfsdf\nsdfasdfasd\nasdasdasd\nasdasdasdasda\nsdfsdf\nsdfsdfsd\nsdfsdfs\nsdfsdfsd\nsdfsdfs\nHiya.");
				output += output += output += output += output;
				break;
			default:
				output = ("Invalid task selection.");
				System.out.println("Check your switch case. The # of buttons and switch cases does not match!");
		}
		sp.setContent(new Text(output));
	}
	
	public static void main(String[] args)
	{
		try
		{
			launch(args);
		} catch (Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
}
