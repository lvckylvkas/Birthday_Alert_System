package input;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InputFields extends JPanel{

	InputField name;
	InputField birthday;
	
	public InputFields() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		name = new InputField("Name");
		add(name);
		birthday = new InputField("Birthday");
		add(birthday);

	}
	
	public void clear() {
		name.text.setText("");
		birthday.text.setText("");
	}
}
