package output;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Checker c;
	
	public GUI(String s) {
		super(s);
		this.setVisible(true);
		JTextArea output = new JTextArea();
		Checker c = new Checker();
		String result = "";
		//checks who has birthday and appends to result string
		for(String name : c.getBirthdayPeople())
			result += name + " has Birthday!\n";
		//if no one has birthday, close program
		if(result.equals(""))
			System.exit(0);
		//add result to textarea
		output.setText(result);
		add(output);
		output.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new GUI("Birthday Alert");

	}

}
