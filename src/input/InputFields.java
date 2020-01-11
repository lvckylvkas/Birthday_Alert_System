package input;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InputFields extends JPanel{

	InputField name;
	InputField birthday;
	
	public InputFields() {
		//boxlayout, so the inputfields are stacked on top of each other
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		name = new InputField("Name");
		add(name);
		birthday = new InputField("Birthday");
		add(birthday);

	}
	
	//clears inputs in the textfields
	public void clear() {
		name.text.setText("");
		birthday.text.setText("");
	}
}
